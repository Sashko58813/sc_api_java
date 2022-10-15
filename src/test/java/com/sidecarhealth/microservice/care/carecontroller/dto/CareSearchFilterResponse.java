package com.sidecarhealth.microservice.care.carecontroller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CareSearchFilterResponse {
    @JsonProperty("careType")
    private CareTypeDTO[] careType;
    @JsonProperty("locations")
    private CareLocationsDTO[] locations;
}
