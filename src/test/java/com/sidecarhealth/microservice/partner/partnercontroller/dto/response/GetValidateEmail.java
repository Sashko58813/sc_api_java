package com.sidecarhealth.microservice.partner.partnercontroller.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetValidateEmail implements Serializable {

    private String message;
    private Boolean valid;
}
