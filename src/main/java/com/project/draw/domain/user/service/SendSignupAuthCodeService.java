package com.project.draw.domain.user.service;

import com.project.draw.domain.user.exception.UserAlreadyExistException;
import com.project.draw.domain.user.facade.AuthCodeFacade;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.domain.user.presentation.dto.request.SendAuthCodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@RequiredArgsConstructor
@Service
public class SendSignupAuthCodeService {

    private final UserFacade userFacade;
    private final AuthCodeFacade authCodeFacade;

    @Transactional
    public void execute(@Valid SendAuthCodeRequest request) {

        String email = request.getEmail();

        if(userFacade.emailIsExist(email)) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        authCodeFacade.sendMail(email);
    }
}