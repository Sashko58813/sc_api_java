package com.name.microservice.doctor.review.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class ReviewMemberRequest {
    public String memberUuid;
    public int npi;
}
