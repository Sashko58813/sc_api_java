package com.sidecarhealth.microservice.doctor.specialty.tests;

import com.sidecarhealth.microservice.authentication.api.UserController;
import com.sidecarhealth.microservice.authentication.dto.response.SessionDTO;
import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.specialty.api.SpecialtyController;
import com.sidecarhealth.microservice.doctor.specialty.data.SpecialtyData;
import com.sidecarhealth.microservice.doctor.specialty.dto.ContentDTO;
import com.sidecarhealth.microservice.doctor.specialty.dto.SpecialtyRequest;
import com.sidecarhealth.microservice.doctor.specialty.dto.SpecialtyResponse;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.sidecarhealth.microservice.authentication.dataproviders.AuthDataProviders.FI_IL_ACCOUNT1;

@Log4j2
@SuppressWarnings("all")
public class SpecialtyControllerTests extends BaseClass {
    UserController userController;
    SpecialtyController specialtyController;
    SpecialtyData specialtyData;

    @BeforeMethod
    public void setUpCareTests() {
        userController = new UserController();
        specialtyController = new SpecialtyController();
        specialtyData = new SpecialtyData();
    }

    @Test()
    public void specialtyReturnsValidInfo() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        log.info("When: calling specialty endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        SpecialtyResponse spcialtyRes = specialtyController.specialtyResponse(SpecialtyRequest.builder().build(),
                sessionDTO.getToken());
        log.info("Then: it returns valid data");
        softAssert.assertEquals(spcialtyRes.getPage(), 0,
                "page mismatch");
        softAssert.assertEquals(spcialtyRes.getTotalPages(), 4,
                "totalPages mismatch");
        softAssert.assertEquals(spcialtyRes.getTotalElements(), 71,
                "totalElements mismatch");
        softAssert.assertEquals(spcialtyRes.getSize(), 20,
                "size mismatch");
        softAssert.assertEquals(spcialtyRes.isLast(), false,
                "last mismatch");
        softAssert.assertEquals(spcialtyRes.isFirst(), true,
                "first mismatch");
        ContentDTO[] content = spcialtyRes.getContent();
        for (int i = 0; i < content.length; i++) {
            softAssert.assertEquals(content[i].getId(), specialtyData.expId().get(i), "id mismatch");
            softAssert.assertEquals(content[i].getOrder(), specialtyData.expOrder().get(i), "order mismatch");
            softAssert.assertEquals(content[i].getUuid(), specialtyData.expUuid().get(i), "uuid mismatch");
            softAssert.assertEquals(content[i].getSpecialty(), specialtyData.expSpecialty().get(i), "specialty mismatch");
            softAssert.assertEquals(content[i].getSpecialty(), specialtyData.expIcon().get(i), "icon mismatch");
        }
        softAssert.assertAll();
    }
}
