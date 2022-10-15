package com.sidecarhealth.microservice.doctor.careRate.tests;

import com.sidecarhealth.microservice.authentication.api.UserController;
import com.sidecarhealth.microservice.authentication.dto.response.SessionDTO;
import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.careRate.api.CareRateAdminController;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.AdminRatesRequest;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.sidecarhealth.microservice.authentication.dataproviders.AuthDataProviders.FI_IL_ACCOUNT1;

@Log4j2
@SuppressWarnings("all")
public class CareRateAdminControllerTests extends BaseClass {
    UserController userController;
    CareRateAdminController careRateAdminController;

    @BeforeMethod
    public void setUpCareTests() {
        userController = new UserController();
        careRateAdminController = new CareRateAdminController();
    }

    @Test()
    public void doctorAdminReturnsValidInformation() throws Exception {
        log.info("When: calling care partner rates endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        Response doctorViewRes = careRateAdminController.adminRates(AdminRatesRequest.builder()
                        .npi(1285716969)
                        .build(),
                sessionDTO.getToken());
        log.info("Then: 200 OK with correct data");
        validateResponse(doctorViewRes, 200, "Care partner rates call was not successful");
    }
}
