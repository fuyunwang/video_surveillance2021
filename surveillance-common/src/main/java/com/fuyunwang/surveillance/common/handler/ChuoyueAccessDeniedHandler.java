package com.fuyunwang.surveillance.common.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fuyunwang.chuoyue.common.base.ResponseCode;
//import com.fuyunwang.chuoyue.common.base.ResponseResult;
//import com.fuyunwang.chuoyue.common.utils.GlobalUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Date: 2020/10/4 10:30
 * @Author: FuyunWang
 * @Description: 处理多个资源服务器的异常.403
 */
public class ChuoyueAccessDeniedHandler {
//    implements AccessDeniedHandler
//    @Override
//    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
//        httpServletResponse.setContentType("application/json;charset=utf-8");
//        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
//        PrintWriter out = httpServletResponse.getWriter();
//
//        out.write(new ObjectMapper().writeValueAsString(
//                ResponseResult.createByError(
//                        ResponseCode.ACCESS_DENIED.getCode(),
//                        ResponseCode.ACCESS_DENIED.getDesc(),
//                        GlobalUtil.data("对不起,您的请求被拒绝了")
//                )
//        ));
//        out.flush();
//        out.close();
//    }
}
