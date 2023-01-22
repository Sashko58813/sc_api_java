package com.name.microservice.care.carebookmarkcontroller.api;

import com.name.microservice.baseclass.BaseClass;

public class CareBookmarkController extends BaseClass {
    final private String ADD_BOOKMARK = "/members/me/drugs/bookmarks";
    final private String REMOVE_BOOKMARK = "/members/me/drugs/bookmarks/{bookmarkUuid}";
}
