package com.sidecarhealth.microservice.expense.card.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GetAdminMemberCard implements Serializable {
    private String last4;
    private String state;
    private String fulfillment;
    private Date created;
    private Date shipped;
    private String tracking;
    private Boolean expedited;
    private Long id;
}
