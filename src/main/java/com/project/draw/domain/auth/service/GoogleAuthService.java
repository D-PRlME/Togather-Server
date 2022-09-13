package com.project.draw.domain.auth.service;

import com.project.draw.domain.auth.domain.RefreshToken;
import com.project.draw.domain.auth.domain.repository.RefreshTokenRepository;
import com.project.draw.domain.auth.presentation.dto.response.TokenResponse;
import com.project.draw.domain.user.domain.Authority;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.domain.repository.UserRepository;
import com.project.draw.global.image.DefaultImage;
import com.project.draw.global.properties.AuthProperties;
import com.project.draw.global.security.jwt.JwtProperties;
import com.project.draw.global.security.jwt.JwtTokenProvider;
import com.project.draw.infrastructure.feign.client.GoogleAuth;
import com.project.draw.infrastructure.feign.client.GoogleInfo;
import com.project.draw.infrastructure.feign.dto.request.GoogleCodeRequest;
import com.project.draw.infrastructure.feign.dto.response.GoogleInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class GoogleAuthService {

    private final GoogleAuth googleAuth;
    private final GoogleInfo googleInfo;
    private final AuthProperties authProperties;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public TokenResponse execute(String code) {

        String accessToken = googleAuth.googleAuth(
                GoogleCodeRequest.builder()
                        .code(URLDecoder.decode(code, StandardCharsets.UTF_8))
                        .clientId(authProperties.getClientId())
                        .clientSecret(authProperties.getClientSecret())
                        .redirectUri(authProperties.getRedirectUrl())
                        .build()
        ).getAccessToken();

        GoogleInfoResponse googleInfoResponse = googleInfo.googleInfo(accessToken);

        String email = googleInfoResponse.getEmail();
        String name = googleInfoResponse.getName();

        String refreshToken = jwtTokenProvider.createRefreshToken(email);

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .email(email)
                        .token(refreshToken)
                        .expiration(jwtProperties.getRefreshExp())
                        .build()
        );
        createUser(email, name);

        return TokenResponse
                .builder()
                .accessToken(jwtTokenProvider.createAccessToken(email))
                .refreshToken(refreshToken)
                .expiredAt(LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .build();
    }

    private void createUser(String email, String name) {
        if (userRepository.findByEmail(email).isEmpty()) {
            userRepository.save(
                    User.builder()
                            .email(email)
                            .name(name)
                            .authority(Authority.USER)
                            .profileImageUrl(DefaultImage.USER_PROFILE_IMAGE)
                            .build());
        }
    }
}