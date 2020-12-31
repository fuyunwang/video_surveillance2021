package com.fuyunwang.surveillance.auth.prop;

import lombok.Data;

/**
 * @Date: 2020/10/4 10:02
 * @Author: FuyunWang
 * @Description: Oauth2需要的参数
 */
@Data
public class ChuoyueOauth2ClientsProperties {
    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}
