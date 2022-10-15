package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import lombok.Data;

@Data
public class DoctorCareRateDTO {
    private String sidecarCode;
    private double averageProviderRate;
}
