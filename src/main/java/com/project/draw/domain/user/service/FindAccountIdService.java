package com.project.draw.domain.user.service;

import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.AuthCodeFacade;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.domain.user.presentation.dto.response.FindAccountIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FindAccountIdService {

    private final UserFacade userFacade;
    private final AuthCodeFacade authCodeFacade;

    @Transactional
    public FindAccountIdResponse execute() {

        User user = userFacade.getCurrentUser();

        authCodeFacade.checkIsVerified(user.getEmail());

        return new FindAccountIdResponse(user.getAccountId());
    }
}