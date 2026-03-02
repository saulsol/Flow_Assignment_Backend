package com.example.fileuploadservice.util;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomFileUtil {

    @Value("${file.upload-dir}")
    private String uploadPath;

    @PostConstruct
    public void init(){
        File tempFolder = new File(uploadPath);

        if(!tempFolder.exists()){
            tempFolder.mkdirs();
        }else{
            tempFolder.getAbsolutePath();
        }
    }

    public String saveFile (MultipartFile file) throws IOException {

        String savedName = UUID.randomUUID() + "_" + file.getOriginalFilename(); // 파일명 중복 방지
        Path savePath = Paths.get(uploadPath, savedName);
        // 원본 파일 업로드
        Files.copy(file.getInputStream(), savePath);

        return savedName;
    }

    public void deleteFile(String savedFileName) throws IOException {

        Path filePath = Paths.get(uploadPath, savedFileName);

        Files.deleteIfExists(filePath);
    }


}
