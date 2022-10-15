package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Data;

@Data
public class CareQuantityQueryMapDTO {
    private String brandedOrGenericId;
    private String gsn;
    private String qty;
    private String drugName;
}
