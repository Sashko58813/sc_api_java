package com.sidecarhealth.microservice.doctor.memberview.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.memberview.dto.request.ViewDoctorsRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class MemberViewController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/doc/v2/swagger-ui.html#/MemberView_Controller
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
