package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Data;

@Data
public class CareAddressDTO {
    private String street;
    private String city;
    private String state;
    private String zip;
    private double lon;
    private double lat;
}
