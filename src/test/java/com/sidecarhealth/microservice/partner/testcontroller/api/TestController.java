package com.sidecarhealth.microservice.partner.testcontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;

public class TestController extends BaseClass {
    // https://qa-api.sidecarhealth.com/ptnr/v1/swagger-ui.html#/Test_Controller
    final private String CACHE = "/tests/cache"; //GET, DELETE
    final private String RUN_CROWN_JOBS = "/tests/cron-jobs";
    final private String GROUP_UPDATE_PAYMENT_METHOD = "/tests/group/{groupUuid}/paymentMethod/{paymentMethodId}/update";
    final private String REMOVE_LATEST_QUOTE = "/tests/latestquoterequest";
    final private String SENTRY_ERROR = "/tests/sentry";
}
