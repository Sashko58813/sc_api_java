package com.sidecarhealth.microservice.authentication.dataproviders;

import com.sidecarhealth.microservice.authentication.dto.request.LoginData;
import lombok.extern.log4j.Log4j2;

@SuppressWarnings("all")
@Log4j2
public class AuthDataProviders {
    public static LoginData FI_IL_ACCOUNT1 = LoginData.builder()
            .username("AutomationscqaIL64947@gmail.com").password("Test1234!").build();
    public static LoginData GFI_ACCOUNT1 = LoginData.builder()
            .username("sasha.scqa+slNS0zYpi3mCLUsRxtA4HMyX@gmail.com").password("Test1234!").build();
}
