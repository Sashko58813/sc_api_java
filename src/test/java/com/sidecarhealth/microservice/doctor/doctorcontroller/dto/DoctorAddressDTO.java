package com.sidecarhealth.microservice.doctor.doctorcontroller.dto;

import lombok.Data;

@Data
public class DoctorAddressDTO {
    private String id;
    private String uuid;
    private String street;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private double lon;
    private double lat;
    private String phone;
    private String fax;
    private String primary;
}
