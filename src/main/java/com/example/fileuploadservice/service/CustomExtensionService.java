package com.example.fileuploadservice.service;

import com.example.fileuploadservice.domain.Extension;
import com.example.fileuploadservice.dto.custom.CustomExtensionDTO;
import com.example.fileuploadservice.dto.fixed.FixedExtensionDTO;
import com.example.fileuploadservice.repository.ExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomExtensionService {

    private final ExtensionRepository extensionRepository;
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

}
