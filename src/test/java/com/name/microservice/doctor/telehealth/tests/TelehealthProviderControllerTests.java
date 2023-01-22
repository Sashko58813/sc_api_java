package com.name.microservice.doctor.telehealth.tests;

import com.name.microservice.authentication.api.UserController;
import com.name.microservice.authentication.dto.response.SessionDTO;
import com.name.microservice.baseclass.BaseClass;
import com.name.microservice.doctor.telehealth.api.TelehealthProviderController;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.name.microservice.authentication.dataproviders.AuthDataProviders.FI_IL_ACCOUNT1;

@Log4j2
@SuppressWarnings("all")
public class TelehealthProviderControllerTests extends BaseClass {
    UserController userController;
    TelehealthProviderController telehealthProviderController;

    @BeforeMethod
    public void setUpCareTests() {
        userController = new UserController();
        telehealthProviderController = new TelehealthProviderController();
    }

    @Test()
    public void telehealthProviderReturnSuccessful() throws Exception {
        log.info("When: calling doctor reviews endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        Response telehealthProviderResp = telehealthProviderController.telehealthProvider(sessionDTO.getToken());
        log.info("Then: 200 OK with correct data");
        validateResponse(telehealthProviderResp, 200, "Telehealth call was not successful");
    }
}
