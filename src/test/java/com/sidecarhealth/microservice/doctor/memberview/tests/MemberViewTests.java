package com.sidecarhealth.microservice.doctor.memberview.tests;

import com.sidecarhealth.microservice.authentication.api.UserController;
import com.sidecarhealth.microservice.authentication.dto.response.SessionDTO;
import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.memberview.api.MemberViewController;
import com.sidecarhealth.microservice.doctor.memberview.dto.request.ViewDoctorsRequest;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.sidecarhealth.microservice.authentication.dataproviders.AuthDataProviders.FI_IL_ACCOUNT1;

@Log4j2
@SuppressWarnings("all")
public class MemberViewTests extends BaseClass {
    UserController userController;
    MemberViewController memberViewController;

    @BeforeMethod
    public void setUpCareTests() {
        userController = new UserController();
        memberViewController = new MemberViewController();
    }

    @Test()
    public void reviewsMemberReturnsValidInformation() throws Exception {
        log.info("When: calling doctor reviews endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);

        Response doctorViewRes = memberViewController.doctorView(ViewDoctorsRequest.builder()
                        .page(0)
                        .size(20)
                        .memberUuid(sessionDTO.getAud())
                        .build(),
                sessionDTO.getToken());
        log.info("Then: 200 OK with correct data");
        validateResponse(doctorViewRes, 200, "Reviews call was not successful");
    }
}
