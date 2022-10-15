package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import lombok.Data;

@Data
public class DoctorContentDTO {
    private String npi;
    private String firstName;
    private String middleName;
    private String lastName;
    private String prefix;
    private String suffix;
    private String credential;
    private String organizationName;
    private String type;
    private String gender;
    private double rating;
    private int reviewCount;
    private DoctorAddressDTO[] addresses;
    private DoctorTaxonomyDTO[] taxonomies;
    private String qualityCategoryScore;
    private DoctorCareRateDTO[] careRates;
}
