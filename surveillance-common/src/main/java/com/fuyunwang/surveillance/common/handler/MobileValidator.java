package com.fuyunwang.surveillance.common.handler;

import com.fuyunwang.chuoyue.common.annotation.IsMobile;
import com.fuyunwang.chuoyue.common.base.GlobalConstant;
import com.fuyunwang.chuoyue.common.utils.RegexUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Date: 2020/10/4 16:02
 * @Author: FuyunWang
 * @Description:
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = GlobalConstant.MOBILE_REG;
                return RegexUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}