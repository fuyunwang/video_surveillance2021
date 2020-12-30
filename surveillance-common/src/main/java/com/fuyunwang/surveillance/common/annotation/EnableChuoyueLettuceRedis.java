package com.fuyunwang.surveillance.common.annotation;

import com.fuyunwang.chuoyue.common.configure.ChuoyueLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ChuoyueLettuceRedisConfigure.class)
public @interface EnableChuoyueLettuceRedis {
}
