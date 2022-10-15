package com.sidecarhealth.microservice.expense.card.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetOnetimeToken implements Serializable {

    private String token;
    private String userToken;
    private String cardToken;
    private Boolean pinIsSet;
    private String state;
}
