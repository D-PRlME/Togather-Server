package com.project.draw.domain.user.facade;

import com.project.draw.domain.chat.exception.RoomNotFoundException;
import com.project.draw.domain.chat.exception.UnableJoinException;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.domain.repository.UserRepository;
import com.project.draw.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByAccountId(accountId);
    }

    public User getUserByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getUserNotJoined(String accountId) {
        return userRepository.findUserNotJoined(accountId)
                .orElseThrow(() -> UnableJoinException.EXCEPTION);
    }

    public User getUserAndFetchRoom(String accountId) {
        return userRepository.findUserAndFetchRoom(accountId)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);
    }
}