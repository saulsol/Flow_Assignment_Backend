package com.example.fileuploadservice.dto.fixedExtension;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FixedExtensionDTO {

    private Long id;

    @JsonProperty("name")
    private String extensionName;

    @JsonProperty("checked")
    private boolean isUsed; // 사용여부
}
