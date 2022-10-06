package com.project.draw.global.util.auth.service;

import com.project.draw.global.security.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryGoogleAuthLinkService {

    private static final String URL = "%s?client_id=%s&redirect_uri=%s&response_type=code"
            + "&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";

    private final AuthProperties authProperties;

    public String execute() {
        return String.format(URL,
                authProperties.getBaseUrl(),
                authProperties.getClientId(),
                authProperties.getRedirectUrl());
    }
}