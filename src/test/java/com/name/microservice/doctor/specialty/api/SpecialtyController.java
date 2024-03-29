package com.name.microservice.doctor.specialty.api;

import com.name.microservice.baseclass.BaseClass;
import com.name.microservice.doctor.specialty.dto.SpecialtyRequest;
import com.name.microservice.doctor.specialty.dto.SpecialtyResponse;
import io.restassured.common.mapper.TypeRef;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class SpecialtyController extends BaseClass {
    final private String SPECIALTY = "/specialties";

    public SpecialtyResponse specialtyResponse(SpecialtyRequest specialtyRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNegativeIntegerQueryParam(reqSpec, "page", specialtyRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", specialtyRequest.getSize());
        return reqSpec.when().get(doctorBaseUri + SPECIALTY)
                .then().extract().response()
                .as(new TypeRef<>() {
                });
    }
}
