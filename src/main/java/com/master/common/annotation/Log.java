package com.master.common.annotation;

import com.master.common.constant.StringPoolConstant;

import java.lang.annotation.*;

/**
 * 系统日志 @SysLog(type = "1",value = "操作内容")
 *
 * @author: hxiang
 * @date: 2020/3/4
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 模块名
     */
    String type() default StringPoolConstant.EMPTY;

    /**
     * 操作内容
     */
    String value() default StringPoolConstant.EMPTY;

}
