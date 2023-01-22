package com.name.microservice.doctor.bookmark.tests;

import com.name.microservice.authentication.api.UserController;
import com.name.microservice.authentication.dto.request.LoginData;
import com.name.microservice.authentication.dto.response.SessionDTO;
import com.name.microservice.baseclass.BaseClass;
import com.name.microservice.doctor.bookmark.api.BookmarkController;
import com.name.microservice.doctor.bookmark.dataproviders.BookmarkDataProviders;
import com.name.microservice.doctor.bookmark.dto.BookmarksDoctorsRequest;
import com.name.microservice.doctor.bookmark.dto.BookmarksDoctorsResponse;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.name.microservice.authentication.dataproviders.AuthDataProviders.FI_IL_ACCOUNT1;

@Log4j2
@SuppressWarnings("all")
public class BookmarkTests extends BaseClass {
    UserController userController;
    BookmarkController bookmarkController;
    BookmarksDoctorsResponse bookmarksDoctorsResponse;

    @BeforeMethod
    public void setUpCareTests() {
        userController = new UserController();
        bookmarkController = new BookmarkController();
        bookmarksDoctorsResponse = new BookmarksDoctorsResponse();
    }

    @Test(dataProvider = "DoctorBookmarks", dataProviderClass = BookmarkDataProviders.class)
    public void bookmarkDoctorReturnsValidInfo(LoginData loginData, BookmarksDoctorsResponse doctor) throws Exception {
        SoftAssert softAssert = new SoftAssert();
        log.info("When: calling bookmark doctor endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        BookmarksDoctorsResponse bookmarksDoctorsResp = bookmarkController.bookmarksDoctorsResponse(BookmarksDoctorsRequest.builder()
                        .memberUuid(sessionDTO.getSub()).build(),
                sessionDTO.getToken());
        log.info("Then: Correct data should be returned");
        softAssert.assertEquals(bookmarksDoctorsResp, doctor, "bookmark doctors response mismatch");
        softAssert.assertAll();
    }
}
