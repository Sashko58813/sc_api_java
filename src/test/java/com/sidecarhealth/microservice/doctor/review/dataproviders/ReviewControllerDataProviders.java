package com.sidecarhealth.microservice.doctor.review.dataproviders;

import com.sidecarhealth.microservice.doctor.review.dto.request.ReviewMemberRequest;
import com.sidecarhealth.microservice.doctor.review.dto.request.ReviewsRequest;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;

@SuppressWarnings("all")
@Log4j2
public class ReviewControllerDataProviders {
    @DataProvider(name = "ReviewMember")
    public Object[][] ReviewMember() {
        return new Object[][]{
                {ReviewMemberRequest.builder().npi(1114452901).build()}
        };
    }

    @DataProvider(name = "Reviews")
    public Object[][] Reviews() {
        return new Object[][]{
                {ReviewsRequest.builder().page(0).size(20).npi(1114452901).build()}
        };
    }
}
