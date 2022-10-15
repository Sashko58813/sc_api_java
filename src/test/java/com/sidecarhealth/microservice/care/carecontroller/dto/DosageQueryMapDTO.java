package com.sidecarhealth.microservice.care.carecontroller.dto;

import lombok.Data;

@Data
public class DosageQueryMapDTO {
    private String gsn;
    private String brandedOrGenericId;
    private String strength;
    private String form;
    private String qty;
    private String drugName;
}
