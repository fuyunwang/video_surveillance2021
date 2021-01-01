package com.fuyunwang.surveillance.upms.biz.prop;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @Date: 2020/10/4 18:14
 * @Author: FuyunWang
 * @Description:
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:chuoyue-upms-biz.properties"})
@ConfigurationProperties(prefix = "chuoyue.npms.biz")
public class ChuoyueBizSwaggerProperties {
    private String grantUrl;
    private String name;
    private String scope;
}
