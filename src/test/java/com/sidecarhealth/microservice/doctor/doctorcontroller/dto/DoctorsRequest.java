package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class DoctorsRequest {
    @Builder.Default
    public int page = -1;
    @Builder.Default
    public int size = -1;
    public String gender;
    @Builder.Default
    public double lat = -1;
    @Builder.Default
    public double lon = -1;
    @Builder.Default
    public int radius = -1;
    public String city;
    public String state;
    public String language;
    public String specialty;
    public String priceFairness;
    public String query;
}
