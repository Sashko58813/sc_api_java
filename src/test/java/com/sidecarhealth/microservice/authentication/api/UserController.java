package com.sidecarhealth.microservice.authentication.api;

import com.sidecarhealth.microservice.authentication.dto.request.LoginData;
import com.sidecarhealth.microservice.authentication.dto.response.SessionDTO;
import com.sidecarhealth.microservice.baseclass.BaseClass;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/auth/v1/swagger-ui/index.html#/User%20Controller
    final private String LOGIN = "/login";

    public SessionDTO login(LoginData userControllerData) {
        Response response = given().auth().preemptive()
                .basic(userControllerData.getUsername(), userControllerData.getPassword())
                .when().get(authentiationBaseUri + LOGIN + "?type=" + userControllerData.getType())
                .then().extract().response();

        return response.as(new TypeRef<>() {
        });
    }
}
