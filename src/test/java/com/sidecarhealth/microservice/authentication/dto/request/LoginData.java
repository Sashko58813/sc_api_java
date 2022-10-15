package com.sidecarhealth.microservice.authentication.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class LoginData {
    public static final String PASSWORD_TYPE = "password";

    @NonNull
    public String username;
    @NonNull
    public String password;
    @Builder.Default
    public String type = PASSWORD_TYPE;
}
