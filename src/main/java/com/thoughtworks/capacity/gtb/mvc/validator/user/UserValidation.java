package com.thoughtworks.capacity.gtb.mvc.validator.user;

import com.thoughtworks.capacity.gtb.mvc.common.ErrorMessage;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/9/11 13:49
 * @Description ***
 **/
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { UserValidator.class })
public @interface UserValidation {
    boolean required() default true;

    String message() default ErrorMessage.USER_INVALID;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
