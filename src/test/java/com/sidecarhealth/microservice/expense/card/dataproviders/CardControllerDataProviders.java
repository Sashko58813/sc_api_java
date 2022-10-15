package com.sidecarhealth.microservice.expense.card.dataproviders;

import com.sidecarhealth.microservice.authentication.dto.request.LoginData;
import com.sidecarhealth.microservice.baseclass.BaseClass;
import org.testng.annotations.DataProvider;

import java.util.List;

public class CardControllerDataProviders extends BaseClass {


    public static LoginData SHARED_LOGIN_DATA = LoginData.builder()
            .username("milena.scqa+20211202@gmail.com")
            .password("Test1234!").build();

    public static LoginData ADMIN_LOGIN_DATA = LoginData.builder()
            .username(adminUsername)
            .password(adminPassword)
            .type("admin").build();

    @DataProvider(name = "login")
    public Object[][] login() {

        return new Object[][]{
                {SHARED_LOGIN_DATA}
        };
    }
}
