package com.name.microservice.care.carecontroller.dto;

import lombok.Data;

@Data
public class CareBrandQueryMapDTO {
    private String brandedOrGenericId;
    private String drugName;
    private String drugDetailCustomized;
}
