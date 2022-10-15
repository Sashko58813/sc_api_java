package com.sidecarhealth.microservice.doctor.specialty.dto;

import lombok.Data;

@Data
public class ContentDTO {
    private Integer id;
    private String uuid;
    private String specialty;
    private String icon;
    private Integer order;
}
