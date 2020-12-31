package com.fuyunwang.surveillance.auth.translator;

import com.fuyunwang.surveillance.common.base.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * @Date: 2020/10/4 10:17
 * @Author: FuyunWang
 * @Description: 将Oauth2认证过程中的异常自定义响应格式
 */
@Slf4j
@Component
public class ChuoyueWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity translate(Exception e) throws Exception {
        ResponseEntity.BodyBuilder status = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        String message = "认证失败";
        log.error(message, e);
        if (e instanceof UnsupportedGrantTypeException) {
            message = "不支持该认证类型";
            return status.body(ResponseResult.createByError(message));
        }
        if (e instanceof InvalidGrantException) {
            if (StringUtils.containsIgnoreCase(e.getMessage(), "Invalid refresh token")) {
                message = "refresh token无效";
                return status.body(ResponseResult.createByError(message));
            }
            if (StringUtils.containsIgnoreCase(e.getMessage(), "locked")) {
                message = "用户已被锁定，请联系管理员";
                return status.body(ResponseResult.createByError(message));
            }
            message = "用户名或密码错误";
            return status.body(ResponseResult.createByError(message));
        }
        return status.body(ResponseResult.createByError(message));
    }
}
