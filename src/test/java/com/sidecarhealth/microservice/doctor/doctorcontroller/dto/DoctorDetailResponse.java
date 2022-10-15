package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DoctorDetailResponse {
    private int npi;
    private String firstName;
    private String middleName;
    private String lastName;
    private String otherFirstName;
    private String otherMiddleName;
    private String otherLastName;
    private String organizationName;
    private String prefix;
    private String gender;
    private String credential;
    private String status;
    private String type;
    private String licensedAt;
    private float rating;
    private int reviewCount;
    private DoctorTaxonomyDTO[] taxonomies;
    private DoctorAddressDTO[] addresses;
    private String[] languages;
    private String[] affiliations;
    private String[] reviews;
    private String[] organizationOtherNames;
    @JsonProperty("averageRatings")
    private DoctorAverageRatingDTO averageRatings;
    private String createdAt;
    private String updatedAt;
    private Boolean bookmarked;
}
