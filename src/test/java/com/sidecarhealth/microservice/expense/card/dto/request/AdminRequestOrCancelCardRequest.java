package com.sidecarhealth.microservice.expense.card.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Builder
@Getter
@Setter
@SuppressWarnings("all")
public class AdminRequestOrCancelCardRequest {
    @NonNull
    public String memberUuid;
    @Builder.Default
    public String reason = "lost";
    @Builder.Default
    public String action = "new";
    @Builder.Default
    public String expedite = "false";
}
