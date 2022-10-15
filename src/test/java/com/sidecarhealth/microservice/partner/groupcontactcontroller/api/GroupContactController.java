package com.sidecarhealth.microservice.partner.groupcontactcontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;

public class GroupContactController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/ptnr/v1/swagger-ui.html#/Group_Contact_Controller
    final private String UPDATE = "/contacts";
    final private String PROFILE_UUID = "/contacts/{uuid}";
    final private String CREATE = "/contacts/add";
    final private String SET_CREDENTIALS = "/contacts/credentials";
    final private String INVITE = "/contacts/invite";
    final private String LOGIN = "/contacts/login";
    final private String GROUP_MEMBERS = "/contacts/members";
    final private String PASSWORD_RESET = "/contacts/password/reset/request";
    final private String SIGNUP = "/contacts/signup";
}
