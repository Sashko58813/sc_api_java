package com.sidecarhealth.microservice.doctor.bookmark.dto;

import lombok.Data;

@Data
public class BookmarkAddressDTO {
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
    private boolean primary;
}
