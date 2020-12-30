package com.fuyunwang.surveillance.common.exception;

/**
 * @Date: 2020/10/4 14:16
 * @Author: FuyunWang
 * @Description:
 */
public class ValidateCodeException extends Exception{

    private static final long serialVersionUID = 7514854456967620043L;

    public ValidateCodeException(String message){
        super(message);
    }
}