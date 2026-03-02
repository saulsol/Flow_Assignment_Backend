package com.example.fileuploadservice.service;

import com.example.fileuploadservice.domain.Extension;
import com.example.fileuploadservice.dto.customExtension.CustomExtensionDTO;
import com.example.fileuploadservice.dto.fixedExtension.FixedExtensionDTO;
import com.example.fileuploadservice.dto.fixedExtension.ReqFixedExtensionIsUsedDTO;
import com.example.fileuploadservice.repository.ExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExtensionService {

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


    @Transactional(readOnly = true)
    public List<CustomExtensionDTO> findCustomExtensions(){
        return extensionRepository.findCustomExtensions()
                .stream()
                .map(e -> new CustomExtensionDTO(
                        e.getId(),
                        e.getExtensionName()
                ))
                .toList();
    }

    public void saveCustomExtension(CustomExtensionDTO customExtensionDTO){
        Extension newCustomExtension = Extension.builder()
                .extensionName(customExtensionDTO.getExtensionName())
                .isFixed(false) // 커스텀 확장자
                .build();
        extensionRepository.save(newCustomExtension);
    }

    public void deleteCustomExtension(Long id){
        extensionRepository.deleteById(id);
    }

    // 확장자 전체 조회
    public List<String> findAllExtensions() {
        return extensionRepository.findAll()
                .stream()
                .map(Extension::getExtensionName)
                .toList();
    }

}
