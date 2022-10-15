package com.sidecarhealth.microservice.doctor.review.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class ReviewsRequest {
    @Builder.Default
    public int page = -1;
    @Builder.Default
    public int size = -1;
    public int npi;
}
