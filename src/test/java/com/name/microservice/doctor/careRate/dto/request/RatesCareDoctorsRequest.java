package com.name.microservice.doctor.careRate.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class RatesCareDoctorsRequest {
    @Builder.Default
    public int page = -1;
    @Builder.Default
    public int size = -1;
    public String memberUuid;
    public String scCode;
    public String receiveAt;
    public String[] specialties;
    public String zipCode;
    public String state;
    public double lat;
    public double lon;
    public float radius;
    public String priceSort;
}
