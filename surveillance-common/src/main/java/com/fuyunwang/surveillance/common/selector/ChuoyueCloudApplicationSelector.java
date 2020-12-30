package com.fuyunwang.surveillance.common.selector;

import com.fuyunwang.chuoyue.common.configure.ChuoyueAuthExceptionConfigure;
import com.fuyunwang.chuoyue.common.configure.ChuoyueOAuth2FeignConfigure;
import com.fuyunwang.chuoyue.common.configure.ChuoyueServiceProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Date: 2020/10/4 12:26
 * @Author: FuyunWang
 * @Description:
 */
public class ChuoyueCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                ChuoyueAuthExceptionConfigure.class.getName(),
                ChuoyueOAuth2FeignConfigure.class.getName(),
                ChuoyueServiceProtectConfigure.class.getName()
        };
    }
}