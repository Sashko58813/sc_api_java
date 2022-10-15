package com.sidecarhealth.microservice.doctor.bookmark.dataproviders;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;

import static com.sidecarhealth.microservice.authentication.dataproviders.AuthDataProviders.FI_IL_ACCOUNT1;
import static com.sidecarhealth.microservice.doctor.bookmark.data.BookmarkData.DOCTOR_1255383139;

@SuppressWarnings("all")
@Log4j2
public class BookmarkDataProviders {
    @DataProvider(name = "DoctorBookmarks")
    public Object[][] DoctorBookmarks() {
        return new Object[][]{
                {FI_IL_ACCOUNT1, DOCTOR_1255383139()}
        };
    }
}
