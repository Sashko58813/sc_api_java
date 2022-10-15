package com.sidecarhealth.microservice.care.carecontroller.tests;

import com.sidecarhealth.microservice.authentication.api.UserController;
import com.sidecarhealth.microservice.authentication.dto.request.LoginData;
import com.sidecarhealth.microservice.authentication.dto.response.SessionDTO;
import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.care.carecontroller.api.CareController;
import com.sidecarhealth.microservice.care.carecontroller.data.CareControllerData;
import com.sidecarhealth.microservice.care.carecontroller.dataproviders.CareControllerDataProviders;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareContentDTO;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareLocationsDTO;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareOptionDTO;
import com.sidecarhealth.microservice.care.carecontroller.dto.CarePubDetailRequest;
import com.sidecarhealth.microservice.care.carecontroller.dto.CarePubDetailResponse;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareSearchFilterResponse;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareSearchRequest;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareSearchResponse;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareTypeDTO;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.sidecarhealth.microservice.authentication.dataproviders.AuthDataProviders.FI_IL_ACCOUNT1;
import static com.sidecarhealth.microservice.care.carecontroller.data.CareControllerData.expCrestorSearch;
import static com.sidecarhealth.microservice.care.carecontroller.data.CareControllerData.noMatchingFromSearch;

@Log4j2
@SuppressWarnings("all")
public class CareControllerTests extends BaseClass {
    UserController userController;
    CareController careController;
    CareControllerData careControllerData;

    @BeforeMethod
    public void setUpCareTests() {
        userController = new UserController();
        careController = new CareController();
        careControllerData = new CareControllerData();
    }

    @Test(dataProvider = "CarePubDetail", dataProviderClass = CareControllerDataProviders.class)
    public void carePubDetail(CarePubDetailRequest carePubDetailData) throws Exception {
        SoftAssert softAssert = new SoftAssert();
        log.info("When: calling public care detail with uuid");
        SessionDTO loginSession = userController.login(FI_IL_ACCOUNT1);
        CarePubDetailResponse pubDetailRes = careController.carePubDetail(carePubDetailData, loginSession.getToken());

        log.info("Then: name param should be returned");
        softAssert.assertEquals(pubDetailRes.getTitle(), carePubDetailData.drugName,
                "title mismatch");
        softAssert.assertAll();
    }

    @Test()
    public void validateCarePubFilters() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        log.info("When: looking up public filters");
        CareSearchFilterResponse careSearchFilterResponse = careController.carePubFilters();

        log.info("Then: filters should return the correct values");
        // careType
        List<String> careTypeValues = new ArrayList<>();
        List<String> careTypeLabels = new ArrayList<>();
        List<List<String>> careTypeOptionValues = new ArrayList<>();
        List<List<String>> careTypeOptionLabels = new ArrayList<>();
        for (CareTypeDTO careType : careSearchFilterResponse.getCareType()) {
            careTypeValues.add(careType.getValue());
            careTypeLabels.add(careType.getLabel());
            List<String> careOptionValues = new ArrayList<>();
            List<String> careOptionLabels = new ArrayList<>();
            for (CareOptionDTO careOption : careType.getOptions()) {
                careOptionValues.add(careOption.getValue());
                careOptionLabels.add(careOption.getLabel());
            }
            careTypeOptionValues.add(careOptionValues);
            careTypeOptionLabels.add(careOptionLabels);
        }
        // locations
        List<String> locationLabels = new ArrayList<>();
        List<String> locationUuids = new ArrayList<>();
        for (CareLocationsDTO locationsDTO : careSearchFilterResponse.getLocations()) {
            locationLabels.add(locationsDTO.getLabel());
            locationUuids.add(locationsDTO.getUuid());
        }
        softAssert.assertEquals(CareControllerData.expCareTypeValues(), careTypeValues);
        softAssert.assertEquals(CareControllerData.expCareTypeLabels(), careTypeLabels);
        softAssert.assertEquals(CareControllerData.expCareTypeOptionsValues(), careTypeOptionValues);
        softAssert.assertEquals(CareControllerData.expCareTypeOptionsLabels(), careTypeOptionLabels);
        softAssert.assertEquals(CareControllerData.expLocationsLabel(), locationLabels);
        softAssert.assertEquals(CareControllerData.expLocationsUuid(), locationUuids);
        softAssert.assertAll();
    }

    @Test(dataProvider = "CarePubSearchCrestor", dataProviderClass = CareControllerDataProviders.class)
    public void carePubSearchCrestorShouldReturnCorrectContent(CareSearchRequest careSearchRequest) throws Exception {
        SoftAssert softAssert = new SoftAssert();
        log.info("When: public search Crestor");
        CareSearchResponse careSearchResponse = careController.carePubSearch(careSearchRequest);

        log.info("Then: Correct Content values should be returned");
        softAssert.assertEquals(careSearchResponse.getContent(), expCrestorSearch());
        softAssert.assertAll();
    }

    @Test(dataProvider = "CarePubSearchGeneric", dataProviderClass = CareControllerDataProviders.class)
    public void carePubSearchGenericShouldIncludeBrandInResult(CareSearchRequest careSearchRequest, String genericName, String brandName) throws Exception {
        SoftAssert softAssert = new SoftAssert();
        log.info("When: public search Crestor");
        CareSearchResponse careSearchResponse = careController.carePubSearch(careSearchRequest.toBuilder().query(genericName).build());

        log.info("Then: Correct Content values should be returned");
        Set<String> uniqueTitles = new HashSet<>();
        for (CareContentDTO careContent : careSearchResponse.getContent()) {
            uniqueTitles.add(careContent.getTitle());
        }
        softAssert.assertTrue(uniqueTitles.containsAll(List.of(genericName, brandName)),
                "Not both generic and brand names are found");
        softAssert.assertAll();
    }

    @Test(dataProvider = "CareSearchReturnsEmpty", dataProviderClass = CareControllerDataProviders.class)
    public void certainCareShouldNotShowUpInCareSearch(LoginData loginData, String sideCarCode) throws Exception {
        SoftAssert softAssert = new SoftAssert();
        log.info("When: public search Crestor");
        SessionDTO loginSession = userController.login(loginData);
        CareSearchResponse careSearchResponse = careController.careSearch(
                CareSearchRequest.builder()
                        .memberUuid(loginSession.getSub()).query(sideCarCode).build(),
                loginSession.getToken());

        log.info("Then: Correct Content values should be returned");
        softAssert.assertEquals(careSearchResponse, noMatchingFromSearch(),
                sideCarCode + " is searchable on " + loginData.getUsername());
        softAssert.assertAll();
    }
}
