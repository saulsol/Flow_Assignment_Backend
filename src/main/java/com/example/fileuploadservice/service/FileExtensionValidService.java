package com.example.fileuploadservice.service;

import com.example.fileuploadservice.dto.file.CheckFileExtensionDTO;
import com.example.fileuploadservice.repository.ExtensionRepository;
import com.example.fileuploadservice.repository.FileEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FileExtensionValidService {

    private final ExtensionRepository extensionRepository;// 확장자 리스트에서 체크
    public CheckFileExtensionDTO checkFileExtension(String fileName){
        List<String> allExtensions = extensionRepository.findAllExtensions();
        String extension = getExtension(fileName);
        CheckFileExtensionDTO checkFileExtensionDTO = new CheckFileExtensionDTO();
        checkFileExtensionDTO.setFileName(fileName);

        if(allExtensions.contains(extension)){
            checkFileExtensionDTO.setParsable(false);
        }else {
            checkFileExtensionDTO.setParsable(true);
        }

        return checkFileExtensionDTO;
    }

    private String getExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return ""; // 확장자가 없는 경우
        }
        return fileName.substring(lastDotIndex + 1).toLowerCase(); // . 뒤부터 끝까지
    }

}
