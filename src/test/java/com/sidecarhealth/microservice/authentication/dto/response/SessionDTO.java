package com.sidecarhealth.microservice.authentication.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class SessionDTO {
    private String token;
    private String aud;// account uuid
    private String sub;// user uuid
    private String cud;// coverage uuid
    private String fpi;// finger print id
    private Boolean hasPurchased;
    private String firstName;
    private String lastName;
    private String email;
    private String type;
    private String applicationStatus;
    private String coverageStatus;
    private boolean primary;
    // location
    private String country;
    private String state;
    private String city;

    private Double lat;
    private Double lng;

    private String postalCode;
    private String timezone;
    private String urlSlug;

    // roles
    private List<String> roles;
}
