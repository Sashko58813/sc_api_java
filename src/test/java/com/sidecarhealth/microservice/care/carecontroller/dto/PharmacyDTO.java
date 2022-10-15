package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Data;

@Data
public class PharmacyDTO {
    private double distance;
    private String gsn;
    private String ndc;
    private String phone;
    private double qty;
    private CareAddressDTO address;
    private String priceFairness;
    private String image;
    private double averageUnitPrice;
    private double facilityShouldCost;
    private double nonFacilityShouldCost;
    private double facilitySidecarCovers;
    private double nonFacilitySidecarCovers;
    private double facilityCostAfterSidecar;
    private double nonFacilityCostAfterSidecar;
    private CareHoursOfOperationDTO[] hoursOfOperation;
    private String name;
    private double pharmacyRate;
}
