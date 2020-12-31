package com.fuyunwang.surveillance.auth.handler;

import com.fuyunwang.surveillance.common.handler.ChuoyueBaseExceptionHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Date: 2020/10/4 11:01
 * @Author: FuyunWang
 * @Description:
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class ChuoyueAuthExceptionHandler extends ChuoyueBaseExceptionHandler {
}
