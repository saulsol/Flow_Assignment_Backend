package com.example.fileuploadservice.controller;

import com.example.fileuploadservice.dto.custom.CustomExtensionDTO;
import com.example.fileuploadservice.dto.fixed.FixedExtensionDTO;
import com.example.fileuploadservice.service.CustomExtensionService;
import com.example.fileuploadservice.service.FixedExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customExtensions")
public class CustomExtensionController {

    private final CustomExtensionService extensionService;

    @GetMapping
    public ResponseEntity<List<CustomExtensionDTO>> getCustomExtensions(){
        List<CustomExtensionDTO> allFixedExtensions = extensionService.findCustomExtensions();
        return ResponseEntity.ok(allFixedExtensions);
    }

    @PostMapping("/save")
    public void saveCustomExtensions(@RequestBody CustomExtensionDTO customExtensionDTO){
        extensionService.saveCustomExtension(customExtensionDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomExtensions(@PathVariable Long id){
        extensionService.deleteCustomExtension(id);
    }

}
