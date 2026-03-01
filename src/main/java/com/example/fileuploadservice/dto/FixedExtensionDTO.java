package com.example.fileuploadservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class FixedExtensionDTO {

    private Long id;

    private String extensionName;

    private boolean isUsed; // 사용여부
}
