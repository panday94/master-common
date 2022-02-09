package com.master.common.enums;

import lombok.Getter;

/**
 * 系统平台枚举类
 *
 * @author: Yang
 * @date: 2020/10/8
 * @version: 3.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Getter
public enum OSEnum {

    /**
     * 类型：1->苹果手机系统；2->安卓系统；3->windows系统 4->苹果电脑系统 5-> linux系统
     */
    IOS(1, "ios"),

    ANDROID(2, "android"),

    WINDOWS(3, "windows"),

    MACOS(4, "macos"),

    LINUX(5, "linux");

    private final Integer code;

    private final String value;

    /**
     * 构造方法
     *
     * @param code
     * @param value
     */
    private OSEnum(final Integer code, final String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 普通方法
     *
     * @param code
     * @return
     */
    public static String getVlue(Integer code) {
        for (OSEnum c : OSEnum.values()) {
            if (c.getCode().equals(code)) {
                return c.value;
            }
        }
        return null;
    }

    /**
     * 普通方法
     *
     * @param code
     * @return
     */
    public static Integer getCode(String value) {
        for (OSEnum c : OSEnum.values()) {
            if (c.getValue().equals(value)) {
                return c.code;
            }
        }
        return null;
    }

}
