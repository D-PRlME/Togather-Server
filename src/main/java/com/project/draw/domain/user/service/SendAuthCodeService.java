package com.project.draw.domain.user.service;

import com.project.draw.domain.user.exception.UserNotFoundException;
import com.project.draw.domain.user.facade.AuthCodeFacade;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.domain.user.presentation.dto.request.SendAuthCodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@RequiredArgsConstructor
@Service
public class SendAuthCodeService {

    private final AuthCodeFacade authCodeFacade;
    private final UserFacade userFacade;

    public void execute(@Valid SendAuthCodeRequest request) {

        String email = request.getEmail();

        if (!userFacade.emailIsExist(email)) {
            throw UserNotFoundException.EXCEPTION;
        }

        authCodeFacade.sendMail(email);
    }
}