package com.sidecarhealth.microservice.doctor.doctorcontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorDetailResponse;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorResponse;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorSearchFilterResponse;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorSuggestResponse;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorsDetailRequest;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorsRequest;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorsSuggestRequest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class DoctorController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/doc/v2/swagger-ui.html#/Doctor_Controller
    final private String DOCTORS = "/doctors";
    final private String DOCTORS_DETAILS = "/doctors/{npi}";
    final private String DOCTORS_AFFILIATIONS = "/doctors/{npi}/affiliations"; // POST, DELETE
    final private String REMOVE_ORGANIZATION_OTHER_NAME = "/doctors/{npi}/organizationOtherNames";
    final private String REMOVE_TAXONOMY = "/doctors/{npi}/taxonomies";
    final private String SEARCH_FILTERS = "/doctors/search-filters";
    final private String DOCTORS_SUGGEST = "/doctors/suggest";

    public DoctorResponse doctors(DoctorsRequest doctorsRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        if (doctorsRequest.getLat() != -1) {
            reqSpec.queryParam("lat", doctorsRequest.getLat());
        }
        if (doctorsRequest.getLon() != -1) {
            reqSpec.queryParam("lon", doctorsRequest.getLon());
        }
        addNonNegativeIntegerQueryParam(reqSpec, "page", doctorsRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", doctorsRequest.getSize());
        addNonEmptyStringQueryParam(reqSpec, "gender", doctorsRequest.getGender());
        addNonNegativeIntegerQueryParam(reqSpec, "radius", doctorsRequest.getRadius());
        addNonEmptyStringQueryParam(reqSpec, "language", doctorsRequest.getLanguage());
        addNonEmptyStringQueryParam(reqSpec, "specialty", doctorsRequest.getSpecialty());
        addNonEmptyStringQueryParam(reqSpec, "priceFairness", doctorsRequest.getPriceFairness());
        addNonEmptyStringQueryParam(reqSpec, "query", doctorsRequest.getQuery());
        addNonEmptyStringQueryParam(reqSpec, "city", doctorsRequest.getCity());
        addNonEmptyStringQueryParam(reqSpec, "state", doctorsRequest.getState());

        return reqSpec.get(doctorBaseUri + DOCTORS)
                .then().extract().response()
                .as(new TypeRef<>() {
                });
    }

    public DoctorDetailResponse doctorsDetail(DoctorsDetailRequest doctorsDetailRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNullBooleanQueryParam(reqSpec, "excludeSyntheticNpis", doctorsDetailRequest.getExcludeSyntheticNpis());
        // Required
        reqSpec.pathParam("npi", doctorsDetailRequest.getNpi());
        return reqSpec.get(doctorBaseUri + DOCTORS_DETAILS)
                .then().extract().response()
                .as(new TypeRef<>() {
                });
    }

    public DoctorSearchFilterResponse doctorSearchFilter(String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        return reqSpec.get(doctorBaseUri + SEARCH_FILTERS)
                .then().extract().response()
                .as(new TypeRef<>() {
                });
    }

    public DoctorSuggestResponse doctorSuggest(DoctorsSuggestRequest doctorsSuggestRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        if (doctorsSuggestRequest.getLat() != -1) {
            reqSpec.queryParam("lat", doctorsSuggestRequest.getLat());
        }
        if (doctorsSuggestRequest.getLon() != -1) {
            reqSpec.queryParam("lon", doctorsSuggestRequest.getLon());
        }
        addNonNegativeIntegerQueryParam(reqSpec, "radius", doctorsSuggestRequest.getRadius());
        addNonEmptyStringQueryParam(reqSpec, "city", doctorsSuggestRequest.getCity());
        addNonEmptyStringQueryParam(reqSpec, "state", doctorsSuggestRequest.getState());
        addNonNullBooleanQueryParam(reqSpec, "excludeSyntheticNpis", doctorsSuggestRequest.getExcludeSyntheticNpis());
        addNonEmptyStringQueryParam(reqSpec, "query", doctorsSuggestRequest.getQuery());

        return reqSpec.get(doctorBaseUri + DOCTORS_SUGGEST)
                .then().extract().response()
                .as(new TypeRef<>() {
                });
    }
}
