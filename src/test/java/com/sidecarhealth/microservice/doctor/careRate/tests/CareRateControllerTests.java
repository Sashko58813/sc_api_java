package com.sidecarhealth.microservice.doctor.careRate.tests;

import com.sidecarhealth.microservice.authentication.api.UserController;
import com.sidecarhealth.microservice.authentication.dto.response.SessionDTO;
import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.careRate.api.CareRateController;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.DoctorPartnersRateCaresDoctorsRequest;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.DoctorPartnersRateRequest;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.DoctorRatesRequest;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.RatesCareDoctorsRequest;
import com.sidecarhealth.microservice.doctor.careRate.dto.request.RatesEntriesRequest;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.sidecarhealth.microservice.authentication.dataproviders.AuthDataProviders.FI_IL_ACCOUNT1;

@Log4j2
@SuppressWarnings("all")
public class CareRateControllerTests extends BaseClass {
    UserController userController;
    CareRateController careRateController;

    @BeforeMethod
    public void setUpCareTests() {
        userController = new UserController();
        careRateController = new CareRateController();
    }

    @Test()
    public void doctorPartnersRatesReturnsValidInformation() throws Exception {
        log.info("When: calling care partner rates endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        Response doctorViewRes = careRateController.partnersRates(DoctorPartnersRateRequest.builder()
                        .npi(1285716969)
                        .state("Dallas")
                        .partnerUuid("ptnr_y6ELGA77zHxcQoTneXy2kqxwM4Jw51ptnr_y6ELGA77zHxcQoTneXy2kqxwM4Jw51")
                        .zipCode("75052")
                        .insuranceFilingUuid("sch_fi_2021_2022")
                        .build(),
                sessionDTO.getToken());
        log.info("Then: 200 OK with correct data");
        validateResponse(doctorViewRes, 200, "Care partner rates call was not successful");
    }

    @Test()
    public void doctorPartnersRatesCaresDoctorsReturnsValidInformation() throws Exception {
        log.info("When: calling doctor partner rates endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        Response doctorViewRes = careRateController.partnersRatesCaresDoctors(DoctorPartnersRateCaresDoctorsRequest.builder()
                        .state("Texas")
                        .partnerUuid("ptnr_y6ELGA77zHxcQoTneXy2kqxwM4Jw51ptnr_y6ELGA77zHxcQoTneXy2kqxwM4Jw51")
                        .zipCode("43215")
                        .insuranceFilingUuid("sch_fi_2021_2022")
                        .sidecarCode("21695028790")
                        .lat(39.966856)
                        .lon(-83.01296)
                        .radius(8)
                        .priceSort("ASC")
                        .page(0)
                        .size(20)
                        .build(),
                sessionDTO.getToken());
        log.info("Then: 200 OK with correct data");
        validateResponse(doctorViewRes, 200, "Doctor partner rates call was not successful");
    }

    @Test()
    public void doctorRateReturnsValidInformation() throws Exception {
        log.info("When: calling doctor rates endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        Response doctorViewRes = careRateController.rates(DoctorRatesRequest.builder()
                        .npi(1285716969)
                        .memberUuid(sessionDTO.getSub())
                        .build(),
                sessionDTO.getToken());
        log.info("Then: 200 OK with correct data");
        validateResponse(doctorViewRes, 200, "Doctor rates call was not successful");
    }

    @Test()
    public void ratesCaresDoctorsReturnsValidInformation() throws Exception {
        log.info("When: calling rates care doctor endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        Response doctorViewRes = careRateController.ratesCaresDoctors(RatesCareDoctorsRequest.builder()
                        .memberUuid(sessionDTO.getSub())
                        .sidecarCode("21695028790")
                        .lat(39.966856)
                        .lon(-83.01296)
                        .page(0)
                        .size(20)
                        .radius(8)
                        .priceSort("ASC")
                        .build(),
                sessionDTO.getToken());
        log.info("Then: 200 OK with correct data");
        validateResponse(doctorViewRes, 200, "rates care doctor call was not successful");
    }

    @Test()
    public void ratesEntriesReturnsValidInformation() throws Exception {
        log.info("When: calling rates entries endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        Response doctorViewRes = careRateController.ratesEntries(RatesEntriesRequest.builder()
                        .npi(1285716969)
                        .sidecarCode("21695028790")
                        .build(),
                sessionDTO.getToken());
        log.info("Then: 200 OK with correct data");
        validateResponse(doctorViewRes, 200, "rates entries  call was not successful");
    }
}
