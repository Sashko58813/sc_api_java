package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import lombok.Data;

@Data
public class DoctorAverageRatingDTO {
    private int npi;
    private int reviewCount;
    private float overall;
    private float waitTime;
    private float bedside;
    private float receipt;
    private float negotiate;
}
