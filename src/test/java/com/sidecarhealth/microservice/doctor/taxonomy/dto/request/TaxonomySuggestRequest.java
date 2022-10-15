package com.sidecarhealth.microservice.doctor.taxonomy.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class TaxonomySuggestRequest {
    @Builder.Default
    public int page = -1;
    @Builder.Default
    public int size = -1;
    public String query;
}
