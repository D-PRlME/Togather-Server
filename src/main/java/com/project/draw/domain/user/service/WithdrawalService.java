package com.project.draw.domain.user.service;


import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.domain.repository.UserRepository;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.domain.user.presentation.dto.request.WithdrawalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WithdrawalService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(WithdrawalRequest request) {

        User user = userFacade.getCurrentUser();

        userFacade.checkPassword(user, request.getPassword());

        userRepository.delete(user);
    }
}