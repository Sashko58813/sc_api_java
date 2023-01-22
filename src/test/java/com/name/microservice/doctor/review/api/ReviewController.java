package com.name.microservice.doctor.review.api;

import com.name.microservice.baseclass.BaseClass;
import com.name.microservice.doctor.review.dto.request.ReviewMemberRequest;
import com.name.microservice.doctor.review.dto.request.ReviewsRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ReviewController extends BaseClass {
    final private String MEMBER_REVIEW = "/member-review";
    final private String REVIEWS = "/reviews"; // GET, POST, PUT, DELETE

    public Response memberReview(ReviewMemberRequest reviewMemberRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonEmptyStringQueryParam(reqSpec, "memberUuid", reviewMemberRequest.getMemberUuid());
        addNonNegativeIntegerQueryParam(reqSpec, "npi", reviewMemberRequest.getNpi());

        return reqSpec.get(doctorBaseUri + MEMBER_REVIEW)
                .then().extract().response();
    }

    public Response reviews(ReviewsRequest reviewsRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNegativeIntegerQueryParam(reqSpec, "page", reviewsRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", reviewsRequest.getSize());
        // Required
        addNonNegativeIntegerQueryParam(reqSpec, "npi", reviewsRequest.getNpi());
        return reqSpec.get(doctorBaseUri + REVIEWS)
                .then().extract().response();
    }
}
