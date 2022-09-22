package com.project.draw.domain.user.facade;

import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithUserDetails;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserFacadeTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserFacade userFacade;

    @Test

    @WithUserDetails(value="admin")
    void 유저_객체_가져오기() {

        //given
        User user = User.builder().build();
        final String email = "test@dsm.hs.kr";

        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(email, null, null));

        given(userRepository.findByEmail(email))
                .willReturn(Optional.of(user));

        //when then
        assertEquals(user, userFacade.getCurrentUser());
    }
}