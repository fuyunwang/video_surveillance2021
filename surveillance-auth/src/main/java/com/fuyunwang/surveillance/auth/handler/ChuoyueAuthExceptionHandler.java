package com.fuyunwang.surveillance.auth.handler;

import com.fuyunwang.surveillance.common.base.ResponseResult;
import com.fuyunwang.surveillance.common.exception.InternalException;
import com.fuyunwang.surveillance.common.handler.ChuoyueBaseExceptionHandler;
import com.fuyunwang.surveillance.common.utils.GlobalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Date: 2020/10/4 11:01
 * @Author: FuyunWang
 * @Description:
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class ChuoyueAuthExceptionHandler extends ChuoyueBaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseResult<Object>> translate(Exception e) throws Exception {
        ResponseEntity.BodyBuilder status = ResponseEntity.status(HttpStatus.OK);
        String message = "认证失败";
        log.error(message, e);
        if (e instanceof UnsupportedGrantTypeException) {
            message = "不支持该认证类型";
            return status.body(ResponseResult.createByError(message, GlobalUtil.data(message)));
        }
        if (e instanceof InvalidGrantException) {
            if (StringUtils.containsIgnoreCase(e.getMessage(), "Invalid refresh token")) {
                message = "refresh token无效";
                return status.body(ResponseResult.createByError(message, GlobalUtil.data(message)));
            }
            if (StringUtils.containsIgnoreCase(e.getMessage(), "locked")) {
                message = "用户已被锁定，请联系管理员";
                return status.body(ResponseResult.createByError(message, GlobalUtil.data(message)));
            }
            message = "用户名或密码错误";
            return status.body(ResponseResult.createByError(message, GlobalUtil.data(message)));
        }
        return status.body(ResponseResult.createByError(message, GlobalUtil.data(message)));
    }
}
