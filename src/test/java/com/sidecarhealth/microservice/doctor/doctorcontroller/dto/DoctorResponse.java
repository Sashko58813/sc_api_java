package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DoctorResponse {
    private int page;
    private int totalPages;
    private int totalElements;
    private int size;
    private Boolean last;
    private Boolean first;
    @JsonProperty("content")
    private DoctorContentDTO[] content;
}
