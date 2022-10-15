package com.sidecarhealth.microservice.care.carecontroller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CareTypeDTO {
    private String value;
    private String label;
    @JsonProperty("options")
    private CareOptionDTO[] options;
}
