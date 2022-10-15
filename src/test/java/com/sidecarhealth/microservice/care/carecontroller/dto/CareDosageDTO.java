package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Data;

@Data
public class CareDosageDTO {
    private String label;
    private DosageQueryMapDTO queryMap;
    private String selected;
}
