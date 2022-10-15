package com.sidecarhealth.microservice.doctor.review.tests;

import com.sidecarhealth.microservice.authentication.api.UserController;
import com.sidecarhealth.microservice.authentication.dto.request.LoginData;
import com.sidecarhealth.microservice.authentication.dto.response.SessionDTO;
import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.review.api.ReviewController;
import com.sidecarhealth.microservice.doctor.review.dataproviders.ReviewControllerDataProviders;
import com.sidecarhealth.microservice.doctor.review.dto.request.ReviewMemberRequest;
import com.sidecarhealth.microservice.doctor.review.dto.request.ReviewsRequest;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.sidecarhealth.microservice.authentication.dataproviders.AuthDataProviders.FI_IL_ACCOUNT1;

@Log4j2
@SuppressWarnings("all")
public class ReviewControllerTests extends BaseClass {
    UserController userController;
    ReviewController reviewController;

    @BeforeMethod
    public void setUpCareTests() {
        userController = new UserController();
        reviewController = new ReviewController();
    }

    @Test(dataProvider = "ReviewMember", dataProviderClass = ReviewControllerDataProviders.class)
    public void reviewsMemberReturnsValidInformation(ReviewMemberRequest reviewMemberRequest) throws Exception {
        log.info("When: calling doctor reviews endpoint with valid token");
        SessionDTO logionDTO = userController.login(FI_IL_ACCOUNT1);
        Response reviewsRes = reviewController.memberReview(reviewMemberRequest.toBuilder()
                        .memberUuid(logionDTO.getSub())
                        .build()
                , logionDTO.getToken());

        log.info("Then: 200 OK with correct data");
        validateResponse(reviewsRes, 200, "Reviews call was not successful");
    }

    @Test(dataProvider = "Reviews", dataProviderClass = ReviewControllerDataProviders.class)
    public void reviewsReturnsValidInformation(ReviewsRequest reviewsRequest) throws Exception {
        log.info("When: calling doctor reviews endpoint with valid token");
        SessionDTO loginDTO = userController.login(FI_IL_ACCOUNT1);
        SessionDTO sessionDTO = userController.login(LoginData.builder().username("AutomationscqaIL64947@gmail.com").password("Test1234!").type("password").build());
        Response reviewsRes = reviewController.reviews(reviewsRequest.toBuilder().build(), sessionDTO.getToken());

        log.info("Then: 200 OK with correct data");
        validateResponse(reviewsRes, 200, "Reviews call was not successful");
    }
}
