package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DoctorSuggestResponse {
    @JsonProperty("doctors")
    private List<DoctorDTO> doctors;
    @JsonProperty("specialties")
    private List<String> specialties;
}
