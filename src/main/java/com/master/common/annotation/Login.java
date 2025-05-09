package com.master.common.annotation;

import java.lang.annotation.*;

/**
 * 验证登录信息
 *
 * @author: Yang
 * @date: 2023/3/4
 * @version: 1.0.0
 * https://www.panday94.xyz
 * Copyright Ⓒ 2023 熊扬软件开发工作室 Limited All rights reserved.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {

}
