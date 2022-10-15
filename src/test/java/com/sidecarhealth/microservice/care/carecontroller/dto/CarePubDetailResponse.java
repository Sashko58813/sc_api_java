package com.sidecarhealth.microservice.care.carecontroller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarePubDetailResponse {
    @JsonProperty("form")
    private CareFormDTO[] form;
    private String title;
    private String name;
    private String facilitySidecarCovers;
    private String nonFacilitySidecarCovers;
    private String facilityBenefitAmount;
    private String nonFacilityBenefitAmount;
    private String facilityShouldCost;
    private String nonFacilityShouldCost;
    private DescriptionDTO description;
    @JsonProperty("brand")
    private CareBrandDTO[] brand;
    @JsonProperty("quantity")
    private CareQuantityDTO[] quantity;
    @JsonProperty("dosage")
    private CareDosageDTO[] dosage;
    private String bookmarked;
    private String prescriptionsCovered;
    private String msaFactor;
    private double rxAreaFactor;
    private double coverageMsaFactor;
    private double coverageRxAreaFactor;
    private String categorySlug;
    private String genericOrBrandedId;
    private double pharmacyLocationQuantity;
    private boolean pregnancyComplication;
    private boolean drugCoverageRequired;
    private CareMemberInfo memberInfo;
    private boolean maternityCovered;
    private boolean preventative;
    private boolean otcDrug;
    private String category;
    @JsonProperty("pharmacies")
    private PharmacyDTO[] pharmacies;
}
