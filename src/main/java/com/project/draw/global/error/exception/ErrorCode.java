package com.project.draw.global.error.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {


    EXPIRED_TOKEN(401,"AUTH-401-1", "Expired Token" ),
    INVALID_TOKEN(401,"AUTH-401-2","Invalid Token"),
    REFRESH_TOKEN_NOT_FOUND(404, "AUTH-404-1", "Refresh Token Not Found"),

    PASSWORD_NOT_VALID(401, "USER-401-1", "Password Not Valid"),
    USER_NOT_FOUND(404, "USER-404-2", "User Not Found" ),
    USER_ALREADY_EXIST(409, "USER-409-1", "User Already Exist"),

    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error");

    private final Integer status;
    private final String code;
    private final String message;
}