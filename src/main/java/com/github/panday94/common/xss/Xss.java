package com.github.panday94.common.xss;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义xss校验注解
 *
 * @author: Yang
 * @date: 2023/3/4
 * @version: 3.0.0
 * https://www.panday94.xyz
 * Copyright Ⓒ 2023 熊扬软件开发工作室 Limited All rights reserved.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Constraint(validatedBy = {XssValidator.class})
public @interface Xss {
    String message() default "不允许任何脚本运行";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
