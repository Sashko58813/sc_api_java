package com.sidecarhealth.microservice.doctor.bookmark.dto;

import lombok.Data;

@Data
public class BookmarksDoctorsResponse {
    private int page;
    private int totalPages;
    private int totalElements;
    private int size;
    private boolean last;
    private boolean first;
    private BookmarkContentDTO[] content;
}
