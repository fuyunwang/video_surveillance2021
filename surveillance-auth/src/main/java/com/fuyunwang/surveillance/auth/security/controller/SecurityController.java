package com.fuyunwang.surveillance.auth.security.controller;

import com.fuyunwang.surveillance.auth.security.service.ValidateCodeService;
import com.fuyunwang.surveillance.common.base.ResponseResult;
import com.fuyunwang.surveillance.common.exception.InternalException;
import com.fuyunwang.surveillance.common.exception.ValidateCodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2020/12/30 15:29
 */
@RestController
public class SecurityController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public ResponseResult<Object> signout(HttpServletRequest request) throws InternalException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(StringUtils.lowerCase(authorization), "bearer ", "");
        if (!consumerTokenServices.revokeToken(token)) {
            throw new InternalException("退出登录失败");
        }
        return ResponseResult.createBySuccess("退出登陆成功");
    }
    @Autowired
    private ValidateCodeService validateCodeService;

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }
}
