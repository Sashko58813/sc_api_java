package com.sidecarhealth.microservice.doctor.careRate.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.DoctorPartnersRateCaresDoctorsRequest;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.DoctorPartnersRateRequest;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.DoctorRatesRequest;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.RatesCareDoctorsRequest;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.RatesEntriesRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CareRateController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/doc/v2/swagger-ui.html#/CareRate_Controller
    final private String PARTNERS_RATES = "/partners/rates";
    final private String PARTNERS_RATES_DOCTORS = "/partners/rates/cares/doctors";
    final private String RATES = "/rates";
    final private String RATES_DOCTORS = "/rates/cares/doctors";
    final private String RATES_ENTRIES = "/rates/entries";

    public Response partnersRates(DoctorPartnersRateRequest doctorPartnersRateRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNegativeIntegerQueryParam(reqSpec, "page", doctorPartnersRateRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", doctorPartnersRateRequest.getSize());
        addNonNegativeIntegerQueryParam(reqSpec, "npi", doctorPartnersRateRequest.getNpi());
        addNonEmptyStringQueryParam(reqSpec, "state", doctorPartnersRateRequest.getState());
        addNonEmptyStringQueryParam(reqSpec, "partnerUuid", doctorPartnersRateRequest.getPartnerUuid());
        addNonEmptyStringQueryParam(reqSpec, "zipCode", doctorPartnersRateRequest.getZipCode());
        addNonEmptyStringQueryParam(reqSpec, "insuranceFilingUuid", doctorPartnersRateRequest.getInsuranceFilingUuid());
        addNonEmptyStringQueryParam(reqSpec, "query", doctorPartnersRateRequest.getQuery());
        return reqSpec.get(doctorBaseUri + PARTNERS_RATES)
                .then().extract().response();
    }

    public Response partnersRatesCaresDoctors(DoctorPartnersRateCaresDoctorsRequest doctorPartnersRateCaresDoctorsRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNegativeIntegerQueryParam(reqSpec, "page", doctorPartnersRateCaresDoctorsRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", doctorPartnersRateCaresDoctorsRequest.getSize());
        addNonEmptyStringQueryParam(reqSpec, "partnerUuid", doctorPartnersRateCaresDoctorsRequest.getPartnerUuid());
        addNonEmptyStringQueryParam(reqSpec, "state", doctorPartnersRateCaresDoctorsRequest.getState());
        addNonEmptyStringQueryParam(reqSpec, "zipCode", doctorPartnersRateCaresDoctorsRequest.getZipCode());
        addNonEmptyStringQueryParam(reqSpec, "insuranceFilingUuid", doctorPartnersRateCaresDoctorsRequest.getInsuranceFilingUuid());
        addNonEmptyStringQueryParam(reqSpec, "sidecarCode", doctorPartnersRateCaresDoctorsRequest.getSidecarCode());
        addNonNullStringArrayQueryParam(reqSpec, "specialties", doctorPartnersRateCaresDoctorsRequest.getSpecialties());
        reqSpec.queryParam("lat", doctorPartnersRateCaresDoctorsRequest.getLat());
        reqSpec.queryParam("lon", doctorPartnersRateCaresDoctorsRequest.getLon());
        addNonNegativeNumberQueryParam(reqSpec, "radius", doctorPartnersRateCaresDoctorsRequest.getRadius());
        addNonEmptyStringQueryParam(reqSpec, "priceSort", doctorPartnersRateCaresDoctorsRequest.getPriceSort());
        return reqSpec.get(doctorBaseUri + PARTNERS_RATES_DOCTORS)
                .then().extract().response();
    }

    public Response rates(DoctorRatesRequest doctorRatesRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNegativeIntegerQueryParam(reqSpec, "page", doctorRatesRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", doctorRatesRequest.getSize());
        addNonNegativeIntegerQueryParam(reqSpec, "npi", doctorRatesRequest.getNpi());
        addNonEmptyStringQueryParam(reqSpec, "memberUuid", doctorRatesRequest.getMemberUuid());
        addNonEmptyStringQueryParam(reqSpec, "query", doctorRatesRequest.getQuery());
        return reqSpec.get(doctorBaseUri + RATES)
                .then().extract().response();
    }

    public Response ratesCaresDoctors(RatesCareDoctorsRequest ratesCareDoctorsRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNegativeIntegerQueryParam(reqSpec, "page", ratesCareDoctorsRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", ratesCareDoctorsRequest.getSize());
        addNonEmptyStringQueryParam(reqSpec, "memberUuid", ratesCareDoctorsRequest.getMemberUuid());
        addNonEmptyStringQueryParam(reqSpec, "sidecarCode", ratesCareDoctorsRequest.getSidecarCode());
        addNonEmptyStringQueryParam(reqSpec, "receiveAt", ratesCareDoctorsRequest.getReceiveAt());
        addNonNullStringArrayQueryParam(reqSpec, "specialties", ratesCareDoctorsRequest.getSpecialties());
        addNonEmptyStringQueryParam(reqSpec, "zipCode", ratesCareDoctorsRequest.getZipCode());
        addNonEmptyStringQueryParam(reqSpec, "state", ratesCareDoctorsRequest.getState());
        reqSpec.queryParam("lat", ratesCareDoctorsRequest.getLat());
        reqSpec.queryParam("lon", ratesCareDoctorsRequest.getLon());
        addNonNegativeNumberQueryParam(reqSpec, "radius", ratesCareDoctorsRequest.getRadius());
        addNonEmptyStringQueryParam(reqSpec, "priceSort", ratesCareDoctorsRequest.getPriceSort());
        return reqSpec.get(doctorBaseUri + RATES_DOCTORS)
                .then().extract().response();
    }

    public Response ratesEntries(RatesEntriesRequest ratesEntriesRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNegativeIntegerQueryParam(reqSpec, "page", ratesEntriesRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", ratesEntriesRequest.getSize());
        addNonNegativeIntegerQueryParam(reqSpec, "npi", ratesEntriesRequest.getNpi());
        addNonEmptyStringQueryParam(reqSpec, "sidecarCode", ratesEntriesRequest.getSidecarCode());
        return reqSpec.get(doctorBaseUri + RATES_ENTRIES)
                .then().extract().response();
    }
}
