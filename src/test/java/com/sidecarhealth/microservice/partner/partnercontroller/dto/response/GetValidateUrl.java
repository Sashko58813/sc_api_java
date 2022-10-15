package com.sidecarhealth.microservice.partner.partnercontroller.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetValidateUrl implements Serializable {

    private String message;
    private Boolean valid;
}
