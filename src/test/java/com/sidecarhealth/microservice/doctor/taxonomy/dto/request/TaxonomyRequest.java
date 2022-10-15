package com.sidecarhealth.microservice.doctor.taxonomy.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class TaxonomyRequest {
    @Builder.Default
    public int page = -1;
    @Builder.Default
    public int size = -1;
}
