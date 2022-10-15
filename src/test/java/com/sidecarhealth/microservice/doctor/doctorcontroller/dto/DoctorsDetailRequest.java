package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class DoctorsDetailRequest {
    public int npi;
    public Boolean excludeSyntheticNpis;
}
