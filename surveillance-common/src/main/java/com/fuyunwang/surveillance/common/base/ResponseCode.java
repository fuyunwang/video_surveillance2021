package com.fuyunwang.surveillance.common.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(20000,"请求成功"),
    LOGIN_SUCCESS(20001,"登陆成功"),
    LOGOUT_SUCCESS(20002,"登出成功"),
    AUTHENTICATION_SUCCESS(20003,"用户认证成功"),
    BAD_REQUEST(40000,"错误的请求"),
    AUTHENTICATION_FAILURE(40001,"用户认证失败"),
    ILLEGAL_ARGUMENTS(40002,"请求参数不合法"),
    ACCESS_DENIED(40003,"没有权限访问该资源"),
    LOGIN_FAILURE(40004,"用户登陆失败"),
    ERROR(50000,"系统内部错误");

    private final Integer code;
    private final String desc;
}
