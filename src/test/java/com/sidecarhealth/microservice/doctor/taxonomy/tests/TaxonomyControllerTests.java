package com.sidecarhealth.microservice.doctor.taxonomy.tests;

import com.sidecarhealth.microservice.authentication.api.UserController;
import com.sidecarhealth.microservice.authentication.dto.response.SessionDTO;
import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.taxonomy.api.TaxonomyController;
import com.sidecarhealth.microservice.doctor.taxonomy.dto.request.TaxonomyRequest;
import com.sidecarhealth.microservice.doctor.taxonomy.dto.request.TaxonomySuggestRequest;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.sidecarhealth.microservice.authentication.dataproviders.AuthDataProviders.FI_IL_ACCOUNT1;

@Log4j2
@SuppressWarnings("all")
public class TaxonomyControllerTests extends BaseClass {
    UserController userController;
    TaxonomyController taxonomyController;

    @BeforeMethod
    public void setUpCareTests() {
        userController = new UserController();
        taxonomyController = new TaxonomyController();
    }

    @Test()
    public void taxonomyReturnsValidInformation() throws Exception {
        log.info("When: calling taxonomy endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        Response taxonomyRes = taxonomyController.taxonomy(TaxonomyRequest.builder().build(),
                sessionDTO.getToken());

        log.info("Then: 200 OK with correct data");
        validateResponse(taxonomyRes, 200, "Taxonomy call was not successful");
    }

    @Test()
    public void taxonomySuggestionReturnsValidInformation() throws Exception {
        log.info("When: calling taxonomy suggestion endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        Response taxonomySuggestionRes = taxonomyController.taxonomySuggestion(
                TaxonomySuggestRequest.builder().page(0).size(20).build(),
                sessionDTO.getToken());

        log.info("Then: 200 OK with correct data");
        validateResponse(taxonomySuggestionRes, 200, "Taxonomy Suggestion call was not successful");
    }
}
