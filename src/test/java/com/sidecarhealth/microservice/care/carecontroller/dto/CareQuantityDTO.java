package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Data;

@Data
public class CareQuantityDTO {
    private String label;
    private CareQuantityQueryMapDTO queryMap;
    private String selected;
}
