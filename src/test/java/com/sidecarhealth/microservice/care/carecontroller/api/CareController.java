package com.sidecarhealth.microservice.care.carecontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.care.carecontroller.dto.CarePubDetailRequest;
import com.sidecarhealth.microservice.care.carecontroller.dto.CarePubDetailResponse;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareSearchFilterResponse;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareSearchRequest;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareSearchResponse;
import io.restassured.common.mapper.TypeRef;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CareController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/care/v1/swagger-ui.html#/Care_Controller
    final private String CALCULATE = "/cares/calculate";
    final private String DETAIL = "/cares/detail";
    final private String FILTERS = "/cares/filters";
    final private String INFO = "/cares/info";
    final private String INFO_UUID = "/cares/info/{uuid}";
    final private String INFO_UUID_MEDICAL_CODES = "/cares/info/{uuid}/medicalCodes";
    final private String INFO_MARKET_RATE = "/cares/info/marketRate";
    final private String PRESCRIPTIONS = "/cares/prescriptions";
    final private String PUB_DETAIL = "/cares/pub/detail";
    final private String PUB_FILTERS = "/cares/pub/filters";
    final private String PUB_SEARCH = "/cares/pub/search";
    final private String RATES = "/cares/rates";
    final private String RATES_DUPLICATE = "/cares/rates/duplicate";
    final private String REIMBURSEMENT_INFO = "/cares/reimbursement/info";
    final private String RELATED_TO = "/cares/relatedto";
    final private String SEARCH = "/cares/search";
    final private String SIDECARCODE_DOCTOR_PRICE = "/cares/sidecarCode/{sidecarCode}/doctors/price";
    final private String SUGGEST = "/cares/suggest";

    public CarePubDetailResponse carePubDetail(CarePubDetailRequest carePubDetailRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonEmptyStringQueryParam(reqSpec, "careName", carePubDetailRequest.getCareName());
        addNonEmptyStringQueryParam(reqSpec, "drugName", carePubDetailRequest.getDrugName());
        addNonEmptyStringQueryParam(reqSpec, "careType", carePubDetailRequest.getCareType());
        addNonEmptyStringQueryParam(reqSpec, "careProcedureType", carePubDetailRequest.getCareProcedureType());
        addNonEmptyStringQueryParam(reqSpec, "category", carePubDetailRequest.getCategory());
        addNonEmptyStringQueryParam(reqSpec, "facilityFeeId", carePubDetailRequest.getFacilityFeeId());
        addNonEmptyStringQueryParam(reqSpec, "facilityCode", carePubDetailRequest.getFacilityCode());
        addNonEmptyStringQueryParam(reqSpec, "facilityTypeSlug", carePubDetailRequest.getFacilityTypeSlug());
        addNonEmptyStringQueryParam(reqSpec, "careVersion", carePubDetailRequest.getCareVersion());
        addNonEmptyStringQueryParam(reqSpec, "displayedCareVersion", carePubDetailRequest.getDisplayedCareVersion());
        addNonEmptyStringQueryParam(reqSpec, "filterType", carePubDetailRequest.getFilterType());
        addNonEmptyStringQueryParam(reqSpec, "gsn", carePubDetailRequest.getGsn());
        addNonEmptyStringQueryParam(reqSpec, "qty", carePubDetailRequest.getQty());
        addNonEmptyStringQueryParam(reqSpec, "location", carePubDetailRequest.getLocation());
        addNonEmptyStringQueryParam(reqSpec, "state", carePubDetailRequest.getLocation());
        addNonNullBooleanQueryParam(reqSpec, "includeFAQ", carePubDetailRequest.getIncludeFAQ());
        addNonEmptyStringQueryParam(reqSpec, "brandedOrGenericId", carePubDetailRequest.getBrandedOrGenericId());
        addNonNegativeNumberQueryParam(reqSpec, "numOfPharmacies", carePubDetailRequest.getNumOfPharmacies());
        addNonEmptyStringQueryParam(reqSpec, "careClientServiceType", carePubDetailRequest.getCareClientServiceType());
        addNonEmptyStringQueryParam(reqSpec, "locationLat", carePubDetailRequest.getLocationLat());
        addNonEmptyStringQueryParam(reqSpec, "locationLong", carePubDetailRequest.getLocationLong());
        addNonNegativeNumberQueryParam(reqSpec, "searchRadius", carePubDetailRequest.getSearchRadius());
        addNonEmptyStringQueryParam(reqSpec, "drugDetailCustomized", carePubDetailRequest.getDrugDetailCustomized());
        addNonEmptyStringQueryParam(reqSpec, "form", carePubDetailRequest.getForm());
        addNonEmptyStringQueryParam(reqSpec, "strength", carePubDetailRequest.getStrength());
        addNonNullBooleanQueryParam(reqSpec, "careEpisode", carePubDetailRequest.getCareEpisode());
        // Required
        addNonEmptyStringQueryParam(reqSpec, "uuid", carePubDetailRequest.getUuid());
        addNonEmptyStringQueryParam(reqSpec, "insuranceFilingUuid", carePubDetailRequest.getInsuranceFilingUuid());
        addNonEmptyStringQueryParam(reqSpec, "zipCode", carePubDetailRequest.getZipCode());

        return reqSpec.get(careBaseUri + PUB_DETAIL)
                .then().extract().response()
                .as(new TypeRef<>() {
                });
    }

    public CareSearchFilterResponse carePubFilters() {
        return given().header("token", "null")
                .when().get(careBaseUri + PUB_FILTERS)
                .then().extract().response()
                .as(new TypeRef<>() {
                });
    }

    // Need insuranceFiling param
    public CareSearchResponse carePubSearch(CareSearchRequest careSearchRequest) {
        return careSearch(careSearchRequest, "null");
    }

    // Need memberUuid param
    public CareSearchResponse careSearch(CareSearchRequest careSearchRequest, String token) {
        RequestSpecification reqSpec = given().header("token", token).when();

        addNonNullStringArrayQueryParam(reqSpec, "careTypes", careSearchRequest.getCareTypes());
        addNonEmptyStringQueryParam(reqSpec, "memberUuid", careSearchRequest.getMemberUuid());
        addNonEmptyStringQueryParam(reqSpec, "gender", careSearchRequest.getGender());
        addNonEmptyStringQueryParam(reqSpec, "age", careSearchRequest.getAge());
        addNonEmptyStringQueryParam(reqSpec, "bodyPart", careSearchRequest.getBodyPart());
        addNonEmptyStringQueryParam(reqSpec, "location", careSearchRequest.getLocation());
        addNonEmptyStringQueryParam(reqSpec, "query", careSearchRequest.getQuery());
        addNonEmptyStringQueryParam(reqSpec, "lat", careSearchRequest.getLat());
        addNonEmptyStringQueryParam(reqSpec, "lng", careSearchRequest.getLng());
        addNonEmptyStringQueryParam(reqSpec, "cptCode", careSearchRequest.getCptCode());
        addNonEmptyStringQueryParam(reqSpec, "hcpcsCode", careSearchRequest.getHcpcsCode());
        addNonEmptyStringQueryParam(reqSpec, "drgCode", careSearchRequest.getDrgCode());
        addNonEmptyStringQueryParam(reqSpec, "ascCode", careSearchRequest.getAscCode());
        addNonEmptyStringQueryParam(reqSpec, "customCode", careSearchRequest.getCustomCode());
        addNonEmptyStringQueryParam(reqSpec, "sidecarCode", careSearchRequest.getSidecarCode());
        addNonEmptyStringQueryParam(reqSpec, "episodeCode", careSearchRequest.getEpisodeCode());
        addNonEmptyStringQueryParam(reqSpec, "zipCode", careSearchRequest.getZipCode());
        addNonEmptyStringQueryParam(reqSpec, "state", careSearchRequest.getState());
        addNonNegativeNumberQueryParam(reqSpec, "sidecarPercentage", careSearchRequest.getSidecarPercentage());
        addNonNegativeNumberQueryParam(reqSpec, "msaFactor", careSearchRequest.getMsaFactor());
        addNonNegativeIntegerQueryParam(reqSpec, "page", careSearchRequest.getPage());
        addNonNegativeIntegerQueryParam(reqSpec, "size", careSearchRequest.getSize());
        addNonEmptyStringQueryParam(reqSpec, "insuranceFilingUuid", careSearchRequest.getInsuranceFilingUuid());

        return reqSpec.get(careBaseUri + (token.equals("null") ? PUB_SEARCH : SEARCH))
                .then().extract().response()
                .as(new TypeRef<>() {
                });
    }
}
