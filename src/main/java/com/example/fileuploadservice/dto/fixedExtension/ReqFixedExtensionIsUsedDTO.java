package com.example.fileuploadservice.dto.fixedExtension;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ReqFixedExtensionIsUsedDTO {

    private Long id;

    @JsonProperty("checked")
    private boolean isUsed; // 사용여부
}
