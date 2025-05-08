package com.github.panday94.common.constant;

/**
 * redis常量类
 *
 * @author: Yang
 * @date: 2023/3/4
 * @version: 1.0.0
 * https://www.panday94.xyz
 * Copyright Ⓒ 2023 熊扬软件开发工作室 Limited All rights reserved.
 */
public interface RedisConstant {

    /**
     * 默认redis过期时长，单位：秒 一年
     */
    Long YEAT_EXPIRE = 12 * 30 * 24 * 3600L;

    /**
     * 默认redis过期时长，单位：秒 一个月
     */
    Long DEFAULT_EXPIRE = 30 * 24 * 3600L;

    /**
     * 失效时间 单位：（秒）一周
     */
    Long WEEK_EXPIRE = 7 * 24 * 3600L;

    /**
     * 失效时间 单位：（秒）一天
     */
    Long DAY_EXPIRE = 24 * 3600L;

    /**
     * 失效时间 单位：（秒）一小时
     */
    Long HOUR_SECONDS = 3600L;

    /**
     * 失效时间 单位：（秒）五分钟
     */
    Long FIVE_MINUTES = 5 * 60L;

    /**
     * 失效时间 单位：（秒）一分钟
     */
    Long ONE_MINUTES = 60L;

    /**
     * 限流 redis key
     */
    String RATE_LIMIT_KEY = "rate_limit:";

}
