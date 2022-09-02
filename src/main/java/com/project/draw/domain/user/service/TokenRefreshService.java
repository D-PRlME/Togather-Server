package com.project.draw.domain.user.service;

import com.project.draw.domain.auth.domain.RefreshToken;
import com.project.draw.domain.auth.domain.repository.RefreshTokenRepository;
import com.project.draw.domain.auth.exception.RefreshTokenNotFoundException;
import com.project.draw.domain.auth.presentation.dto.response.TokenResponse;
import com.project.draw.global.security.jwt.JwtProperties;
import com.project.draw.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TokenRefreshService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public TokenResponse execute(String refreshToken) {

        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String email = redisRefreshToken.getEmail();
        String newRefreshToken = jwtTokenProvider.createRefreshToken(email);

        redisRefreshToken.updateToken(newRefreshToken, jwtProperties.getRefreshExp());

        String newAccessToken = jwtTokenProvider.createAccessToken(email);

        return TokenResponse
                .builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .build();
    }
}