package com.fuyunwang.surveillance.common.annotation;

//import com.fuyunwang.chuoyue.common.selector.ChuoyueCloudApplicationSelector;
import com.fuyunwang.surveillance.common.selector.ChuoyueCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ChuoyueCloudApplicationSelector.class)
public @interface ChuoyueCloudApplication {
}
