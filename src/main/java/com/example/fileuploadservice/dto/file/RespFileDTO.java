package com.example.fileuploadservice.dto.file;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RespFileDTO {
    Long id;
    String fileName; // 확장자가 추가된 파일명
}
