package com.name.microservice.doctor.doctorcontroller.dto;

import lombok.Data;

@Data
public class DoctorCareRateDTO {
    private String scCode;
    private double averageProviderRate;
}
