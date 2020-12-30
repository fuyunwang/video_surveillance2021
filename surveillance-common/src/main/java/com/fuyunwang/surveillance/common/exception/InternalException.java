package com.fuyunwang.surveillance.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternalException extends RuntimeException{
    private String errorMesssage;

    public InternalException(String message) {
        this.errorMesssage = message;
    }
}
