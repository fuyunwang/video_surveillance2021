package com.fuyunwang.surveillance.auth.prop;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @Date: 2020/10/4 10:02
 * @Author: FuyunWang
 * @Description:
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:chuoyue-auth.properties"})
@ConfigurationProperties(prefix = "chuoyue.auth")
public class ChuoyueAuthProperties {
    private ChuoyueOauth2ClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;
    private ChuoyueValidateCodeProperties code = new ChuoyueValidateCodeProperties();
    // 免认证路径
    private String anonPath;
}
