package com.name.microservice.card.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostAdminRequestOrCancelCardResponse implements Serializable {
    private String status;
    private String msg;
    private String last4;
    private String state;
}
