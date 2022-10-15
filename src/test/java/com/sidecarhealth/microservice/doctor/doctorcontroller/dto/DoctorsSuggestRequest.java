package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class DoctorsSuggestRequest {
    @Builder.Default
    public double lat = -1;
    @Builder.Default
    public double lon = -1;
    @Builder.Default
    public int radius = -1;
    public String city;
    public String state;
    public Boolean excludeSyntheticNpis;
    public String query;
}
