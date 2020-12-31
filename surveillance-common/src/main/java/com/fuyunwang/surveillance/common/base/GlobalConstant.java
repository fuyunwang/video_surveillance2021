package com.fuyunwang.surveillance.common.base;

/**
 * @description:
 * @author: FuyunWang
 * @time: 2020/7/19 14:17
 */
public class GlobalConstant {
    public static final String TOAST_MESSAGE="message";
    // 简单手机号正则（这里只是简单校验是否为 11位，实际规则更复杂）
    public static final String MOBILE_REG = "[1]\\d{10}";

    public interface ServcieConstant{
       String CHUOYUE_AUTH = "Chuoyue-Auth";
       String CHUOYUE_CLOUD = "Chuoyue-Cloud";
       String CHUOYUE_COMMON = "Chuoyue-Common";
       String CHUOYUE_GATEWAY = "Chuoyue-Gateway";
       String CHUOYUE_REGISTER = "Chuoyue-Register";
       String CHUOYUE_SERVER = "Chuoyue-Upms";
       String CHUOYUE_SERVER_SYSTEM= "Chuoyue-Upms-System";
       String CHUOYUE_SERVER_TEST= "Chuoyue-Upms-Api";
    }

    public interface GatewayFilterConstant{
        /**
         * Zuul请求头TOKEN名称（不要有空格）
         */
        public static final String GATEWAY_TOKEN_HEADER = "GatewayToken";
        /**
         * Zuul请求头TOKEN值
         */
        public static final String GATEWAY_TOKEN_VALUE = "chuoyue:gateway:password";
    }

    public interface ValidateCode{
        /**
         * gif类型
         */
        public static final String GIF = "gif";
        /**
         * png类型
         */
        public static final String PNG = "png";

        /**
         * 验证码 key前缀
         */
        public static final String CODE_PREFIX = "febs.captcha.";
    }
}
