package com.sidecarhealth.microservice.doctor.memberview.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class ViewDoctorsRequest {
    @Builder.Default
    public int page = -1;
    @Builder.Default
    public int size = -1;
    public String memberUuid;
}
