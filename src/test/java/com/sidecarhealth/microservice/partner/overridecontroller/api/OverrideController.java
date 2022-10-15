package com.sidecarhealth.microservice.partner.overridecontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;

public class OverrideController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/ptnr/v1/swagger-ui.html#/Override_Controller
    final private String OVERRIDES = "/overrides"; //POST, PUT
    final private String OVERRIDES_UUID = "/overrides/{uuid}"; //GET, DELETE
    final private String OVERRIDES_BY_BROKER_UUID = "/overrides/receiver/{uuid}";
}
