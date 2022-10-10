package com.project.draw.domain.user.service;

import com.project.draw.domain.user.exception.UserNotFoundException;
import com.project.draw.domain.user.facade.AuthCodeFacade;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.domain.user.presentation.dto.request.SendAuthCodeRequest;
import com.project.draw.global.util.jms.MailType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@RequiredArgsConstructor
@Service
public class SendAuthCodeService {

    private final AuthCodeFacade authCodeFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(@Valid SendAuthCodeRequest request) {

        String email = request.getEmail();

        authCodeFacade.checkEmailDomain(email);

        if (!userFacade.emailIsExist(email)) {
            throw UserNotFoundException.EXCEPTION;
        }

        authCodeFacade.sendMail(MailType.FIND_PASSWORD, email);
    }
}