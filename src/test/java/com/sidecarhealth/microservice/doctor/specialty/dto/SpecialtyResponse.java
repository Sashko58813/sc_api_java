package com.sidecarhealth.microservice.doctor.specialty.dto;

import lombok.Data;

@Data
public class SpecialtyResponse {
    private int page;
    private int totalPages;
    private int totalElements;
    private int size;
    private boolean last;
    private boolean first;
    private ContentDTO[] content;
}
