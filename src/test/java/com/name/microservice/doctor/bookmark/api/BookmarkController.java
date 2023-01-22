package com.name.microservice.doctor.bookmark.api;

import com.name.microservice.baseclass.BaseClass;
import com.name.microservice.doctor.bookmark.dto.BookmarksDoctorsRequest;
import com.name.microservice.doctor.bookmark.dto.BookmarksDoctorsResponse;
import io.restassured.common.mapper.TypeRef;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BookmarkController extends BaseClass {
    final private String BOOKMARKS = "/bookmarks"; // POST, DELETE
    final private String BOOKMARKS_DOCTORS = "/bookmarks/doctors"; // GET

    public BookmarksDoctorsResponse bookmarksDoctorsResponse(BookmarksDoctorsRequest bookmarksDoctorsRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNegativeIntegerQueryParam(reqSpec, "page", bookmarksDoctorsRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", bookmarksDoctorsRequest.getSize());
        addNonEmptyStringQueryParam(reqSpec, "memberUuid", bookmarksDoctorsRequest.getMemberUuid());
        return reqSpec.get(doctorBaseUri + BOOKMARKS_DOCTORS)
                .then().extract().response()
                .as(new TypeRef<>() {
                });
    }
}
