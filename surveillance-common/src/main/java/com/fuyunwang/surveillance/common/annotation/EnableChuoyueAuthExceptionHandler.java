package com.fuyunwang.surveillance.common.annotation;

//import com.fuyunwang.chuoyue.common.configure.ChuoyueAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Date: 2020/10/4 10:34
 * @Author: FuyunWang
 * @Description:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(ChuoyueAuthExceptionConfigure.class)
public @interface EnableChuoyueAuthExceptionHandler {
}
