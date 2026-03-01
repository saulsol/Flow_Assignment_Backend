package com.example.fileuploadservice.service;

import com.example.fileuploadservice.dto.FixedExtensionDTO;
import com.example.fileuploadservice.repository.FixedExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FixedExtensionService {

    private final FixedExtensionRepository fixedExtensionRepository;

    // 고정 확장자 전체 조회
    @Transactional(readOnly = true)
    public List<FixedExtensionDTO> findAllFixedExtensions(){
        return fixedExtensionRepository.findFixedExtensions()
                .stream()
                .map(e -> new FixedExtensionDTO(
                        e.getId(),
                        e.getExtensionName(),
                        e.isUsed()
                ))
                .toList();
    }





}
