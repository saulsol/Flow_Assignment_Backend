package com.example.fileuploadservice.dto.custom;

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
