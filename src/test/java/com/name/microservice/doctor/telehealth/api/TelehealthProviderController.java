package com.name.microservice.doctor.telehealth.api;

import com.name.microservice.baseclass.BaseClass;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TelehealthProviderController extends BaseClass {
    final private String TELEHEALTH_PROVIDER = "/telehealthProviders";

    public Response telehealthProvider(String token) {
        return given().header("token", token)
                .when().get(doctorBaseUri + TELEHEALTH_PROVIDER)
                .then().extract().response();
    }
}
