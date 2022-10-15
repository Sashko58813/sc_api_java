package com.sidecarhealth.microservice.care.carecodecontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;

public class CareCodeController extends BaseClass {
    // Swagger reference: https://dev-api.sidecarhealth.com/care/v1/swagger-ui.html#/Care_Code_Controller
    final private String SEARCH_CPT_HCPCS = "/cpt-hcpcs/search";
    final private String SEARCH_DRG = "/drg/search";
    final private String SEARCH_ICD = "/icds/search";
    final private String PAGE_SEARCH = "/pageSearch"; // cpt/apc/asc/hcpcs/asc/apc/ndc/sidecarCode
    final private String PAGE_SUGGEST = "/pageSuggest"; // apc,asc,cpt,drg,hcpcs,ndc,sidecarCode,custom,correction codes
    final private String SEARCH = "/search"; // first 20 from cpt/apc/asc/hcpcs/asc/apc/ndc/sidecarCode
    final private String SUGGEST = "/suggest"; // first 20 from apc,asc,cpt,drg,hcpcs,ndc,sidecarCode,custom,correction codes
}
