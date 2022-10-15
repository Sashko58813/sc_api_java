package com.sidecarhealth.microservice.doctor.telehealth.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TelehealthProviderController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/doc/v2/swagger-ui.html#/TelehealthProvider_Controller
    final private String TELEHEALTH_PROVIDER = "/telehealthProviders";

    public Response telehealthProvider(String token) {
        return given().header("token", token)
                .when().get(doctorBaseUri + TELEHEALTH_PROVIDER)
                .then().extract().response();
    }
}
