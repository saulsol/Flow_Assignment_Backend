package com.example.fileuploadservice.service;

import com.example.fileuploadservice.domain.Extension;
import com.example.fileuploadservice.dto.FixedExtensionDTO;
import com.example.fileuploadservice.dto.ReqFixedExtensionIsUsedDTO;
import com.example.fileuploadservice.repository.ExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FixedExtensionService {

    private final ExtensionRepository extensionRepository;

    // 고정 확장자 전체 조회
    @Transactional(readOnly = true)
    public List<FixedExtensionDTO> findAllFixedExtensions(){
        return extensionRepository.findFixedExtensions()
                .stream()
                .map(e -> new FixedExtensionDTO(
                        e.getId(),
                        e.getExtensionName(),
                        e.isUsed()
                ))
                .toList();
    }

    // 고정 확정자 사용 여부 업데이트
    public void updateFixedExtensionIsUsed(ReqFixedExtensionIsUsedDTO reqFixedExtensionIsUsedDTO){
        Extension extension = extensionRepository
                .findById(reqFixedExtensionIsUsedDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("확장자가 존재하지 않습니다."));

        extension.changeIsUsed(reqFixedExtensionIsUsedDTO.isUsed());
        extensionRepository.save(extension);
    }





}
