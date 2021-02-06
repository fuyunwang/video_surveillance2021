package com.fuyunwang.surveillance.auth.security.controller;

import com.fuyunwang.surveillance.auth.security.service.ValidateCodeService;
import com.fuyunwang.surveillance.common.base.ResponseResult;
import com.fuyunwang.surveillance.common.exception.InternalException;
import com.fuyunwang.surveillance.common.exception.ValidateCodeException;
import com.fuyunwang.surveillance.common.pojo.ChuoyueUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2020/12/30 15:29
 */
@RestController
public class SecurityController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ValidateCodeService validateCodeService;

    @Resource
    private TokenEndpoint tokenEndpoint;

    @Resource
    private HttpServletRequest request;

    @PostMapping("oauth/token")
    public ResponseResult<Map<String,Object>> postAccessToken(Principal principal, @RequestParam Map<String, String> parameters)
            throws HttpRequestMethodNotSupportedException {
        return custom(tokenEndpoint.postAccessToken(principal, parameters).getBody());
    }

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

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }

    private ResponseResult<Map<String,Object>> custom(OAuth2AccessToken accessToken) {
        Map<String, Object> data = new LinkedHashMap(((DefaultOAuth2AccessToken)accessToken).getAdditionalInformation());
        data.put("access_token", accessToken.getValue());
        data.put("expire_in", accessToken.getExpiresIn());
        data.put("scopes", accessToken.getScope());
        data.put("token_type",accessToken.getTokenType());
        if (accessToken.getRefreshToken() != null) {
            data.put("refresh_token", accessToken.getRefreshToken().getValue());
        }
        return ResponseResult.createBySuccess(request.getServletPath(),data);
    }

}
