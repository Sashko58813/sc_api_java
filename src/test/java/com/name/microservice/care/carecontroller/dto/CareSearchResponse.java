package com.name.microservice.care.carecontroller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CareSearchResponse {
    private int page;
    private int totalPages;
    private int totalElements;
    private int size;
    private boolean last;
    private boolean first;
    @JsonProperty("content")
    private CareContentDTO[] content;
}
