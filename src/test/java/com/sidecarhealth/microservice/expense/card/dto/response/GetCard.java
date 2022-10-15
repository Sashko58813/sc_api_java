package com.sidecarhealth.microservice.expense.card.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GetCard implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long cardId;
    private Long memberId;
    private String memberUuid;
    private String firstName;
    private String lastName;
    private String token;
    private String last4;
    private String state;
    private String fulfillment;
    private Date createdAt;
    private Date shippedAt;
    private String tracking;
    private Boolean expedited;
}
