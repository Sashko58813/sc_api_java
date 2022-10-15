package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Data;

@Data
public class CareFormDTO {
    private String label;
    private CareFormQueryMapDTO queryMap;
    private boolean selected;
}
