package com.sidecarhealth.microservice.doctor.careRate.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class DoctorPartnersRateCaresDoctorsRequest {
    @Builder.Default
    public int page = -1;
    @Builder.Default
    public int size = -1;
    public String partnerUuid;
    public String state;
    public String zipCode;
    public String insuranceFilingUuid;
    public String sidecarCode;
    public String[] specialties;
    public double lat;
    public double lon;
    public float radius;
    public String priceSort;
}
