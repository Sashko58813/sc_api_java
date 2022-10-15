package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class CareSearchRequest {
    public String[] careTypes;
    public String memberUuid;
    public String gender;
    public String age;
    public String bodyPart;
    public String location;
    public String query;
    public String lat;
    public String lng;
    public String cptCode;
    public String hcpcsCode;
    public String drgCode;
    public String apcCode;
    public String ascCode;
    public String customCode;
    public String sidecarCode;
    public String episodeCode;
    public String state;
    public String zipCode;
    @Builder.Default
    public double sidecarPercentage = -1;
    @Builder.Default
    public double msaFactor = -1;
    @Builder.Default
    public int page = -1;
    @Builder.Default
    public int size = -1;
    public String insuranceFilingUuid;
}
