package com.project.draw.infrastructure.feign.client;

import com.project.draw.infrastructure.feign.dto.request.GoogleCodeRequest;
import com.project.draw.infrastructure.feign.dto.response.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "GoogleAuthClient", url = "https://oauth2.googleapis.com/token")
public interface GoogleAuth {

    @PostMapping
    TokenResponse googleAuth(GoogleCodeRequest googleCodeRequest);

}
