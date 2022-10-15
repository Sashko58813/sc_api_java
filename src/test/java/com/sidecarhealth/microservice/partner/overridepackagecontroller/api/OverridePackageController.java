package com.sidecarhealth.microservice.partner.overridepackagecontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;

public class OverridePackageController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/ptnr/v1/swagger-ui.html#/Override_Package_Controller
    final private String OVERRIDE_PACKAGES = "/override-packages"; //POST, PUT
    final private String DELETE_OVERRIDE_PACKAGES_UUID = "/override-packages/{uuid}";
    final private String OVERRIDE_PACKAGES_BY_BROKER_UUID = "/override-packages/broker/{uuid}";
    final private String OVERRIDE_PACKAGES_BY_UUID = "/override-packages/pub/{uuid}";
}
