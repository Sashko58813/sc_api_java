package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import lombok.Data;

import java.util.List;

@Data
public class DoctorSearchFilterResponse {
    private List<String> providerType;
    private List<String> pricePoints;
    private List<String> gender;
    private List<String> languages;
}
