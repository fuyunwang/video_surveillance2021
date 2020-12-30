package com.fuyunwang.surveillance.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @description:
 * @author: FuyunWang
 * @time: 2020/7/25 15:45
 */
public class MobileNotFoundException extends AuthenticationException {
    // ~ Constructors
    // ===================================================================================================

    /**
     * Constructs a <code>BadCredentialsException</code> with the specified message.
     *
     * @param msg the detail message
     */
    public MobileNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Constructs a <code>BadCredentialsException</code> with the specified message and
     * root cause.
     *
     * @param msg the detail message
     * @param t root cause
     */
    public MobileNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
