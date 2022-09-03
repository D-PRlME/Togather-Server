package com.project.draw.domain.auth.presentation;

import com.project.draw.domain.auth.presentation.dto.response.TokenResponse;
import com.project.draw.domain.auth.service.GoogleAuthService;
import com.project.draw.global.util.auth.service.QueryGoogleAuthLinkService;
import com.project.draw.infrastructure.feign.dto.request.CodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/google")
@RestController
public class GoogleController {

    private final GoogleAuthService googleAuthService;
    private final QueryGoogleAuthLinkService queryGoogleAuthLinkService;

    @GetMapping("/auth")
    public String queryGoogleAuthLink() {
        return queryGoogleAuthLinkService.execute();
    }

    @PostMapping("/auth")
    public TokenResponse googleAuthLogin(@RequestBody CodeRequest codeRequest) {
        return googleAuthService.execute(codeRequest);
    }
}