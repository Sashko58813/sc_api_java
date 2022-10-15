package com.sidecarhealth.microservice.doctor.taxonomy.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.taxonomy.dto.request.TaxonomyRequest;
import com.sidecarhealth.microservice.doctor.taxonomy.dto.request.TaxonomySuggestRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class TaxonomyController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/doc/v2/swagger-ui.html#/Taxonomy_Controller
    final private String TAXONOMY = "/taxonomies";
    final private String TAXONOMY_SUGGESTION = "/taxonomies/suggestions";

    public Response taxonomy(TaxonomyRequest taxonomyRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNegativeIntegerQueryParam(reqSpec, "page", taxonomyRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", taxonomyRequest.getSize());

        return reqSpec.get(doctorBaseUri + TAXONOMY)
                .then().extract().response();
    }

    public Response taxonomySuggestion(TaxonomySuggestRequest taxonomySuggestRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNegativeIntegerQueryParam(reqSpec, "page", taxonomySuggestRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", taxonomySuggestRequest.getSize());
        addNonEmptyStringQueryParam(reqSpec, "query", taxonomySuggestRequest.getQuery());
        return reqSpec.when().get(doctorBaseUri + TAXONOMY_SUGGESTION)
                .then().extract().response();
    }
}
