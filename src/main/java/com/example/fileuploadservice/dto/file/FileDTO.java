package com.example.fileuploadservice.dto.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
public class FileDTO {
    Long id;

    String fileName; // 확장자가 추가된 파일명

    MultipartFile multipartFile;
}
