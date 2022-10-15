package com.sidecarhealth.microservice.doctor.bookmark.dto;

import lombok.Data;

@Data
public class BookmarkContentDTO {
    private int npi;
    private String firstName;
    private String lastName;
    private String gender;
    private String credential;
    private String status;
    private String type;
    private String licensedAt;
    private double rating;
    private int reviewCount;
    private BookmarkAddressDTO[] addresses;
    private BookmarkTaxonomyDTO[] taxonomies;
    private String[] languages;
    private String[] organizationOtherNames;
    private String createdAt;
    private String updatedAt;
    private Boolean bookmarked;
}
