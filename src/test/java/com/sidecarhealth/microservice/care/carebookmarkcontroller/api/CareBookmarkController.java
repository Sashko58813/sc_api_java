package com.sidecarhealth.microservice.care.carebookmarkcontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;

public class CareBookmarkController extends BaseClass {
    // Swagger reference: https://dev-api.sidecarhealth.com/care/v1/swagger-ui.html#/Care_BookMark_Controller
    final private String ADD_BOOKMARK = "/members/me/drugs/bookmarks";
    final private String REMOVE_BOOKMARK = "/members/me/drugs/bookmarks/{bookmarkUuid}";
}
