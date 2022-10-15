package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Data;

@Data
public class CareContentDTO {
    private String uuid;
    private String code;
    private String codeType;
    private String title;
    private String category;
    private String subCategory;
    private String categorySlug;
    private String subCategorySlug;
    private int order;
    private boolean episode;
    private boolean careEpisode;
}
