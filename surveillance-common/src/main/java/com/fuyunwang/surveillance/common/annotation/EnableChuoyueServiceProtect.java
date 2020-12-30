package com.fuyunwang.surveillance.common.annotation;

import com.fuyunwang.chuoyue.common.configure.ChuoyueServiceProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ChuoyueServiceProtectConfigure.class)
public @interface EnableChuoyueServiceProtect {
}
