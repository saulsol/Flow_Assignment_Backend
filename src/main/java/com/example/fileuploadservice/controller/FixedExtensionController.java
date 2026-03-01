package com.example.fileuploadservice.controller;

import com.example.fileuploadservice.dto.FixedExtensionDTO;
import com.example.fileuploadservice.service.FixedExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fixedExtensions")
public class FixedExtensionController {

    private final FixedExtensionService fixedExtensionService;

    // 전체 고정 확장자 조회
    @GetMapping
    public ResponseEntity<List<FixedExtensionDTO>> getFixedExtensions(){
        List<FixedExtensionDTO> allFixedExtensions = fixedExtensionService.findAllFixedExtensions();
        return ResponseEntity.ok(allFixedExtensions);
    }



}
