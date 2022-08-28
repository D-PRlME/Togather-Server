package com.project.draw.domain.user.service;

import com.project.draw.domain.auth.presentation.dto.TokenResponse;
import com.project.draw.domain.user.domain.Authority;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.domain.repository.UserRepository;
import com.project.draw.domain.user.exception.UserAlreadyExistException;
import com.project.draw.domain.user.presentation.dto.request.SignupRequest;
import com.project.draw.global.image.DefaultImage;
import com.project.draw.global.security.jwt.JwtProperties;
import com.project.draw.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse execute(SignupRequest request) {

        String accountId = request.getAccountId();
        String name = request.getName();
        String password = request.getPassword();

        if (userRepository.findByAccountId(accountId).isPresent()){
            throw UserAlreadyExistException.EXCEPTION;
        }

        User user = userRepository.save(User.builder()
                .accountId(accountId)
                .name(name)
                .password(passwordEncoder.encode(password))
                .authority(Authority.USER)
                .profileImageUrl(DefaultImage.USER_PROFILE_IMAGE)
                .build()
        );

        String accessToken = jwtTokenProvider.createAccessToken(accountId);
        String refreshToken = jwtTokenProvider.createRefreshToken(accountId);

        return TokenResponse
                .builder()
                .accessToken(accessToken)
                .expiredAt(LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .refreshToken(refreshToken)
                .build();
    }
}