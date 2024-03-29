package com.name.microservice.partner.groupadmincontroller.api;

import com.name.microservice.baseclass.BaseClass;

public class GroupAdminController extends BaseClass {
    final private String ALL_GROUPS = "/admin/groups"; //POST, PUT
    final private String GROUP_MEMBER_DETAILS = "/admin/groups/{uuid}/members"; //POST, PUT
    final private String SEARCH_GROUP = "/admin/groups/suggest"; //Search Group by Group UUID or Partner UUID or Group contact Firstname or Group contact Lastname or Partner Company
}
