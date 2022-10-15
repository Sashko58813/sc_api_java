package com.sidecarhealth.microservice.doctor.bookmark.dto;

import lombok.Data;

@Data
public class BookmarkTaxonomyDTO {
    private String uuid;
    private String license;
    private String code;
    private String title;
    private String state;
    private String specialty;
    private String primary;
}
