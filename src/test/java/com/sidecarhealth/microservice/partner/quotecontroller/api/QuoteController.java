package com.sidecarhealth.microservice.partner.quotecontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;

public class QuoteController extends BaseClass {
    // https://qa-api.sidecarhealth.com/ptnr/v1/swagger-ui.html#/Quote_Controller
    final private String CANCEL_LATEST_QUOTE = "/quotes/cancel-lastest-request";
    final private String GET_LATEST_QUOTE = "/quotes/latest";
    final private String ESTIMATE_PRICING = "/quotes/pricing";
    final private String SAVE_QUOTE = "/quotes/save-partner-quote-request";
}
