package com.name.microservice.partner.groupcontroller.api;

import com.name.microservice.baseclass.BaseClass;

public class GroupController extends BaseClass {
    final private String GROUP = "/groups"; //POST, PUT
    final private String GROUP_DETAILS = "/groups/{uuid}";
    final private String GROUP_MEMBERS_PAYOUT_DETAILS = "/groups/{uuid}/members";
    final private String GROUP_INFO_URL = "/groups/pub/info";
    final private String GROUP_STATS_UUID = "/groups/stats";
}
