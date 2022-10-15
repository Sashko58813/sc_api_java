package com.sidecarhealth.microservice.partner.partneradmincontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;

public class PartnerAdminController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/ptnr/v1/swagger-ui.html#/Partner_Admin_Controller
    final private String SIGNUP_BROKER = "/admin/brokers/signup";
    final private String GET_ALL_PARTNERS = "/admin/partners";
    final private String GET_PARTNER_UUD = "/admin/partners/{uuid}";
    final private String REFRESH_W9 = "/admin/partners/{uuid}/w9FormUrl";
    final private String PARTNER_PARTNERS = "/admin/partners/parents";
    final private String UPDATE_PARTNER = "/admin/partners/profile";
    final private String SIGNUP_PARTNER = "/admin/partners/signup";
    final private String SEARCH_PARTNER = "/admin/partners/suggest"; //Search Partner by UUID or Firstname or Lastname or Company
    final private String SYSTEM_INTEGRATORS = "/admin/partners/system-integrators";


}
