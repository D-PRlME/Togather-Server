package com.project.draw.domain.user.service;

import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.AuthCodeFacade;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.domain.user.presentation.dto.request.UpdateEmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateEmailService {

    private final UserFacade userFacade;
    private final AuthCodeFacade authCodeFacade;

    @Transactional
    public void execute(UpdateEmailRequest request) {

        User user = userFacade.getCurrentUser();

        String newEmail = request.getNewEmail();
        userFacade.emailIsExist(newEmail);

        authCodeFacade.checkIsVerified(newEmail);

        user.updateEmail(newEmail);
    }
}