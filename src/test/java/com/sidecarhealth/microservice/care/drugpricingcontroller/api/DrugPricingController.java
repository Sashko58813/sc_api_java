package com.sidecarhealth.microservice.care.drugpricingcontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;

public class DrugPricingController extends BaseClass {
    // Swagger reference: https://dev-api.sidecarhealth.com/care/v1/swagger-ui.html#/Drug_Pricing_Controller
    final private String DRUG_BY_GSN = "/drugs/{gsn}";
    final private String RELATED_MEDICAL_CONDITIONS = "/drugs/{name}/relatedMedicalConditions"; // GET, PUT
    final private String MEDICAL_CONDITION_OPTIONS = "/drugs/medicalConditionOptions";
    final private String PUB_SUGGEST = "/drugs/pub/suggest";
    final private String SUGGEST = "/drugs/suggest";
}
