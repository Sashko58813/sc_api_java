package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import lombok.Data;

@Data
public class DoctorTaxonomyDTO {
    private String uuid;
    private String license;
    private String code;
    private String title;
    private String state;
    private String specialty;
    private String primary;
}
