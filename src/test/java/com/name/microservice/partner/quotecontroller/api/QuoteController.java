package com.name.microservice.partner.quotecontroller.api;

import com.name.microservice.baseclass.BaseClass;

public class QuoteController extends BaseClass {
    final private String CANCEL_LATEST_QUOTE = "/quotes/cancel-lastest-request";
    final private String GET_LATEST_QUOTE = "/quotes/latest";
    final private String ESTIMATE_PRICING = "/quotes/pricing";
    final private String SAVE_QUOTE = "/quotes/save-partner-quote-request";
}
