package com.project.draw.util;

import com.project.draw.constant.UserConstant;
import com.project.draw.domain.user.domain.User;

import static org.springframework.test.util.ReflectionTestUtils.setField;

public class UserBuilder {

    public static User build() {

        User user = User
                .builder()
                .name(UserConstant.NAME)
                .password(UserConstant.PASSWORD)
                .email(UserConstant.EMAIL)
                .authority(UserConstant.AUTHORITY)
                .build();

        setField(user, "id", UserConstant.ID);

        return user;
    }
}