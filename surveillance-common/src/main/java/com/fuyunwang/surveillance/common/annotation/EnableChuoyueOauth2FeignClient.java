package com.fuyunwang.surveillance.common.annotation;

//import com.fuyunwang.chuoyue.common.configure.ChuoyueOAuth2FeignConfigure;
import com.fuyunwang.surveillance.common.configure.ChuoyueOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ChuoyueOAuth2FeignConfigure.class)
public @interface EnableChuoyueOauth2FeignClient {
}
