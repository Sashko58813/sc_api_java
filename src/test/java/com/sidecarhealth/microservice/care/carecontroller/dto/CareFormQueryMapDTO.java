package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Data;

@Data
public class CareFormQueryMapDTO {
    private String gsn;
    private String brandedOrGenericId;
    private String form;
    private String strength;
    private String qty;
    private String drugName;
}
