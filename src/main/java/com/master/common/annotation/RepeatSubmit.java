package com.master.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解防止表单重复提交
 *
 * @author: hxiang
 * @date: 2021/10/20
 * @version: 1.2.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {

}
