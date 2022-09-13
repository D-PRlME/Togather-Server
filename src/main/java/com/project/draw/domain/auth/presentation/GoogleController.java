package com.project.draw.domain.auth.presentation;

import com.project.draw.domain.auth.presentation.dto.response.TokenResponse;
import com.project.draw.domain.auth.service.GoogleAuthService;
import com.project.draw.global.util.auth.service.QueryGoogleAuthLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GoogleController {

    private final GoogleAuthService googleAuthService;
    private final QueryGoogleAuthLinkService queryGoogleAuthLinkService;

    @GetMapping("/google/auth")
    public String queryGoogleAuthLink() {
        return queryGoogleAuthLinkService.execute();
    }

    @GetMapping("/receiveCode")
    public TokenResponse googleAuthLogin(@RequestParam("code") String code) {
        return googleAuthService.execute(code);
    }
}