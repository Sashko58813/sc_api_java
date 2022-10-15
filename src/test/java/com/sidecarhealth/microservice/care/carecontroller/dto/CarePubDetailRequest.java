package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CarePubDetailRequest {
    public String token;
    public String uuid;
    public String insuranceFilingUuid;
    public String zipCode;
    public String careName;
    public String drugName;
    public String careType;
    public String careProcedureType;
    public String category;
    public String facilityFeeId;
    public String facilityCode;
    public String facilityTypeSlug;
    public String careVersion;
    public String displayedCareVersion;
    public String filterType;
    public String gsn;
    public String qty;
    public String location;
    public String state;
    public Boolean includeFAQ;
    public String brandedOrGenericId;
    @Builder.Default
    public int numOfPharmacies = -1;
    public String careClientServiceType;
    public String locationLat;
    public String locationLong;
    @Builder.Default
    public float searchRadius = -1;
    public String drugDetailCustomized;
    public String form;
    public String strength;
    public Boolean careEpisode;
}
