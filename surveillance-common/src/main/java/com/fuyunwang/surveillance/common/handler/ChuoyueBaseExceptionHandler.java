package com.fuyunwang.surveillance.common.handler;

//import com.fuyunwang.chuoyue.common.base.ResponseCode;
//import com.fuyunwang.chuoyue.common.base.ResponseResult;
//import com.fuyunwang.chuoyue.common.exception.InternalException;
//import com.fuyunwang.chuoyue.common.utils.GlobalUtil;
import com.fuyunwang.surveillance.common.base.ResponseCode;
import com.fuyunwang.surveillance.common.base.ResponseResult;
import com.fuyunwang.surveillance.common.exception.InternalException;
import com.fuyunwang.surveillance.common.utils.GlobalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import javax.validation.Path;
import java.util.List;
import java.util.Set;

/**
 * @Date: 2020/10/4 10:57
 * @Author: FuyunWang
 * @Description:
 */
@Slf4j
public class ChuoyueBaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handleException(InternalException e) {
        log.error("系统内部异常，异常信息", e);
        return ResponseResult.createByError(e.getErrorMesssage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseResult handleAccessDeniedException(){
        return ResponseResult.createByError(ResponseCode.ACCESS_DENIED.getCode(),
                ResponseCode.ACCESS_DENIED.getDesc(),
                GlobalUtil.data(ResponseCode.ACCESS_DENIED.getDesc()));
    }
    //单个参数异常处理
  /*  @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
            message.append(pathArr[1]).append(violation.getMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return ResponseResult.createByError(message.toString());
    }*/
    //实体对象参数异常处理
   /* @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult handleBindException(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return ResponseResult.createByError(message.toString());
    }*/
}
