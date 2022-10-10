package com.project.draw.global.util.jms;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MailType {

    SIGN_UP("signup_email_template.html"),
    FIND_PASSWORD("find_password_email_template.html");

    private final String fileName;
}