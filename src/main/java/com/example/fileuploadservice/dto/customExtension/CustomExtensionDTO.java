package com.example.fileuploadservice.dto.customExtension;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomExtensionDTO {

    private Long id;

    @JsonProperty("name")
    private String extensionName;
}
