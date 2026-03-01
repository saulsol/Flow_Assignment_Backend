package com.example.fileuploadservice.controller;

import com.example.fileuploadservice.dto.fixed.FixedExtensionDTO;
import com.example.fileuploadservice.dto.fixed.ReqFixedExtensionIsUsedDTO;
import com.example.fileuploadservice.service.FixedExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fixedExtensions")
public class FixedExtensionController {

    private final FixedExtensionService extensionService;

    // 전체 고정 확장자 조회
    @GetMapping
    public ResponseEntity<List<FixedExtensionDTO>> getFixedExtensions(){
        List<FixedExtensionDTO> allFixedExtensions = extensionService.findAllFixedExtensions();
        return ResponseEntity.ok(allFixedExtensions);
    }

    // 고정 확정자 부분 업데이트
    @PatchMapping("/fixed")
    public ResponseEntity<Void> updateFixedExtensionIsUsed(@RequestBody ReqFixedExtensionIsUsedDTO request) {
        extensionService.updateFixedExtensionIsUsed(request);
        return ResponseEntity.ok().build();
    }

}
