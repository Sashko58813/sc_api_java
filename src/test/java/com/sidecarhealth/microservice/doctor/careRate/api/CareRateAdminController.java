package com.sidecarhealth.microservice.doctor.careRate.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.AdminRatesRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CareRateAdminController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/doc/v2/swagger-ui.html#/CareRate_Admin_Controller
    final private String ADMIN_RATES = "/admin/rates";
    final private String RATES_ENTRIES = "/admin/rates/entries"; // PUT, POST, DELETE
    final private String RATES_ENTRIES_UPLOAD = "/admin/rates/entries/upload";

    public Response adminRates(AdminRatesRequest adminRatesRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNegativeIntegerQueryParam(reqSpec, "page", adminRatesRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", adminRatesRequest.getSize());
        addNonNegativeIntegerQueryParam(reqSpec, "npi", adminRatesRequest.getNpi());
        return reqSpec.get(doctorBaseUri + ADMIN_RATES)
                .then().extract().response();
    }
}
