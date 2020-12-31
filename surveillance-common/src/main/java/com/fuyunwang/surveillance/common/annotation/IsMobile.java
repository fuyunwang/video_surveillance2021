package com.fuyunwang.surveillance.common.annotation;

//import com.fuyunwang.chuoyue.common.handler.MobileValidator;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
import com.fuyunwang.surveillance.common.handler.MobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileValidator.class)
public @interface IsMobile {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}