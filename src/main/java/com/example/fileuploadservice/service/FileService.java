package com.example.fileuploadservice.service;

import com.example.fileuploadservice.domain.FileEntity;
import com.example.fileuploadservice.dto.file.FileDTO;
import com.example.fileuploadservice.dto.file.RespFileDTO;
import com.example.fileuploadservice.repository.FileEntityRepository;
import com.example.fileuploadservice.util.CustomFileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FileService {

    private final CustomFileUtil customFileUtil;
    private final FileEntityRepository fileEntityRepository;

    public List<RespFileDTO> findAllFiles(){
        return fileEntityRepository.findAll()
                .stream()
                .map(f -> new RespFileDTO(
                        f.getId(),
                        f.getFileName()
                ))
                .toList();
    }

    @Transactional(rollbackFor = IOException.class)
    public void saveFile(FileDTO fileDTO) throws IOException {
        String customFileName = customFileUtil.saveFile(fileDTO.getMultipartFile());
        FileEntity fileEntity = FileEntity.builder()
                .fileName(fileDTO.getFileName()) // 유저가 넘긴 파일명
                .savedName(customFileName) // 실제 파일명
                .build();

        fileEntityRepository.save(fileEntity);
    }

    @Transactional(rollbackFor = IOException.class)
    public void deleteFile(Long id) throws IOException{
        FileEntity entity = fileEntityRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 파일입니다."));
        customFileUtil.deleteFile(entity.getSavedName());

        fileEntityRepository.deleteById(id);
    }

}
