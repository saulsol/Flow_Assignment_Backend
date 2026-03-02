package com.example.fileuploadservice.controller;

import com.example.fileuploadservice.dto.file.CheckFileExtensionDTO;
import com.example.fileuploadservice.dto.file.FileDTO;
import com.example.fileuploadservice.dto.file.FileNameDTO;
import com.example.fileuploadservice.dto.file.RespFileDTO;
import com.example.fileuploadservice.service.FileExtensionValidService;
import com.example.fileuploadservice.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FileController {

    private final FileService fileService;
    private final FileExtensionValidService fileExtensionValidService;

    @GetMapping
    public ResponseEntity<List<RespFileDTO>> getFiles(){
        List<RespFileDTO> allFiles = fileService.findAllFiles();
        return ResponseEntity.ok(allFiles);
    }

    @PostMapping("/save")
    public void saveFile(@ModelAttribute FileDTO fileDTO) throws IOException {
        fileService.saveFile(fileDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFile(@PathVariable Long id) throws IOException{
        fileService.deleteFile(id);
    }

    //파일 확장자 확인
    @PostMapping("/check")
    public CheckFileExtensionDTO checkFileExtension(@RequestBody FileNameDTO fileNameDTO){
        return fileExtensionValidService.checkFileExtension(fileNameDTO.getFileName());
    }

}
