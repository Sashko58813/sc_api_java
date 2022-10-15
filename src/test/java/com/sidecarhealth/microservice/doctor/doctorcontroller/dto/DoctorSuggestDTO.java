package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import lombok.Data;

@Data
public class DoctorSuggestDTO {
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
}
