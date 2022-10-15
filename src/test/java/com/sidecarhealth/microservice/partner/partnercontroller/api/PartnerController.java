package com.sidecarhealth.microservice.partner.partnercontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.partner.partnercontroller.dto.response.GetValidateEmail;
import com.sidecarhealth.microservice.partner.partnercontroller.dto.response.GetValidateUrl;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

import static io.restassured.RestAssured.given;

@Log4j2
public class PartnerController extends BaseClass {
    // https://qa-api.sidecarhealth.com/ptnr/v1/swagger-ui.html#/Partner_Controller
    final private String PARTNER_PROFILE = "/partners/{uuid}/profile";
    final private String UPLOAD_W9 = "/partners/{uuid}/w9-form";
    final private String AGENT = "/partners/agent"; //POST, PUT
    final private String AGENTS = "/partners/agents";
    final private String SETUP_CREDENTIALS = "/partners/credentials";
    final private String VALIDATE_EMAIL = "/partners/email/validate";
    final private String INVITE_PARTNER = "/partners/invite";
    final private String LOGIN = "/partners/login";
    final private String LOGOUT = "/partners/logout";
    final private String UPDATE_PASSWORD = "/partners/password";
    final private String PASSWORD_RESET = "/partners/password/reset/request";
    final private String UPDATE_PROFILE = "/partners/profile";
    final private String SIGNUP_BROKER = "/partners/signup";
    final private String VALIDATE_URL = "/partners/url-slug/validate";


    public GetValidateEmail validatePartnerEmail(String email, Integer expectedStatusCode) throws Exception {
        log.info("Validate partner email");
        log.info("Endpoint: " + partnerBaseUri + VALIDATE_EMAIL);
        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .header("x-api-key", XAPIKEY)
                        .queryParam("email", email)
                        .when()
                        .get(partnerBaseUri + VALIDATE_EMAIL)
                        .then()
                        .extract().response();
        validateResponse(response, expectedStatusCode, "Partner email validate successfully");
        return response.as(GetValidateEmail.class);
    }

    public GetValidateUrl validatePartnerUrl(String url, Integer expectedStatusCode) throws Exception {
        log.info("Validate partner email");
        log.info("Endpoint: " + partnerBaseUri + VALIDATE_URL);
        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .header("x-api-key", XAPIKEY)
                        .queryParam("urlSlug", url)
                        .when()
                        .get(partnerBaseUri + VALIDATE_URL)
                        .then()
                        .extract().response();
        validateResponse(response, expectedStatusCode, "Partner url validate successfully");
        return response.as(GetValidateUrl.class);
    }


}
