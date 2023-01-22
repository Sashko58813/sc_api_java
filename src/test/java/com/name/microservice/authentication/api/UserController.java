package com.name.microservice.authentication.api;

import com.name.microservice.authentication.dto.request.LoginData;
import com.name.microservice.authentication.dto.response.SessionDTO;
import com.name.microservice.baseclass.BaseClass;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserController extends BaseClass {
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
