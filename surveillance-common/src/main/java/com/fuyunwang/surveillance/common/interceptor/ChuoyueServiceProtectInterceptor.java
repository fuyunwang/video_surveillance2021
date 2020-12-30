package com.fuyunwang.surveillance.common.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fuyunwang.chuoyue.common.base.GlobalConstant;
//import com.fuyunwang.chuoyue.common.base.ResponseCode;
//import com.fuyunwang.chuoyue.common.base.ResponseResult;
//import com.fuyunwang.chuoyue.common.utils.GlobalUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Date: 2020/10/4 12:03
 * @Author: FuyunWang
 * @Description: 避免客户端请求绕过网关,直接调用微服务.校验请求头
 */
public class ChuoyueServiceProtectInterceptor implements HandlerInterceptor {
   /* @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(GlobalConstant.ZuulFilterConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(GlobalConstant.ZuulFilterConstant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            //这里尝试不通过网关请求资源是不放行的
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpStatus.FORBIDDEN.value());
            PrintWriter out = response.getWriter();

            out.write(new ObjectMapper().writeValueAsString(
                    ResponseResult.createByError(
                            ResponseCode.ACCESS_DENIED.getCode(),
                            ResponseCode.ACCESS_DENIED.getDesc(),
                            GlobalUtil.data("请通过网关获取资源")
                    )
            ));
            out.flush();
            out.close();
            return false;
        }
    }*/
}
