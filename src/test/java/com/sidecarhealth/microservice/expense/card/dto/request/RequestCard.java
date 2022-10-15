package com.sidecarhealth.microservice.expense.card.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Builder
@Getter
@Setter
@SuppressWarnings("all")
public class RequestCard {
    @NonNull
    public String accountUuid;
    @Builder.Default
    public String reason = "lost";
}
