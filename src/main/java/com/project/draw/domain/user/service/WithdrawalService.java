package com.project.draw.domain.user.service;


import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.domain.repository.UserRepository;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WithdrawalService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute() {

        User user = userFacade.getCurrentUser();

        userRepository.delete(user);
    }
}