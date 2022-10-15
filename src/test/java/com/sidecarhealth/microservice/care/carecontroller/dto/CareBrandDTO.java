package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Data;

@Data
public class CareBrandDTO {
    private String label;
    private CareBrandQueryMapDTO queryMap;
    private String selected;
}
