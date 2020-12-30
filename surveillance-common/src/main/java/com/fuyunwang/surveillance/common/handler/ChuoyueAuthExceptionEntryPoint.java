package com.fuyunwang.surveillance.common.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fuyunwang.chuoyue.common.base.ResponseCode;
//import com.fuyunwang.chuoyue.common.base.ResponseResult;
//import com.fuyunwang.chuoyue.common.utils.GlobalUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Date: 2020/10/4 10:23
 * @Author: FuyunWang
 * @Description: 处理多个资源服务器的异常.401
 */
public class ChuoyueAuthExceptionEntryPoint  {
//    implements AuthenticationEntryPoint
  /*  @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter out = httpServletResponse.getWriter();
        ResponseResult responseResult =null;
        String data = "";
        if (e instanceof InsufficientAuthenticationException) {
            data="请求失败，请联系管理员!";
        }else{
            data="用户认证失败";
        }
        responseResult=ResponseResult.createByError(
                ResponseCode.AUTHENTICATION_FAILURE.getCode(),
                ResponseCode.AUTHENTICATION_FAILURE.getDesc(),
                GlobalUtil.data(data));
        out.write(new ObjectMapper().writeValueAsString(responseResult));
        out.flush();
        out.close();
    }*/
}
