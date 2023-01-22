package com.name.microservice.doctor.memberview.api;

import com.name.microservice.baseclass.BaseClass;
import com.name.microservice.doctor.memberview.dto.request.ViewDoctorsRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class MemberViewController extends BaseClass {
    final private String DOCTORS_VIEWS = "/views/doctors";

    public Response doctorView(ViewDoctorsRequest viewDoctorsRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();
        // Required
        addNonNegativeIntegerQueryParam(reqSpec, "page", viewDoctorsRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", viewDoctorsRequest.getSize());
        addNonEmptyStringQueryParam(reqSpec, "memberUuid", viewDoctorsRequest.getMemberUuid());
        return reqSpec.get(doctorBaseUri + DOCTORS_VIEWS)
                .then().extract().response();
    }
}
