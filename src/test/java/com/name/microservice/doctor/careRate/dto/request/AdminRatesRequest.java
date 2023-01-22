package com.name.microservice.doctor.careRate.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class AdminRatesRequest {
    @Builder.Default
    public int page = -1;
    @Builder.Default
    public int size = -1;
    public int npi;
}
