package com.master.common.enums;

import lombok.Getter;

/**
 * 运行平台枚举
 *
 * @author: Yang
 * @date: 2020/10/8
 * @version: 3.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Getter
public enum PlatFormEnum {

    /**
     * 类型：1->App；2->wechat；3->tiktok-cn；4->alipay；5->baidu；6->H5
     */
    APP(1, "App"),

    WECHAT(2, "wechat"),

    TIKTOK_CN(3, "tiktok-cn"),

    ALIPAY(4, "alipay"),

    BAIDU(5, "baidu"),

    H5(6, "H5");

    private final Integer code;

    private final String value;

    /**
     * 构造方法
     *
     * @param code
     * @param value
     */
    private PlatFormEnum(final Integer code, final String value) {
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
        for (PlatFormEnum c : PlatFormEnum.values()) {
            if (c.getCode().equals(code)) {
                return c.value;
            }
        }
        return null;
    }

    /**
     * 普通方法
     *
     * @param value
     * @return
     */
    public static Integer getValue(String value) {
        for (PlatFormEnum c : PlatFormEnum.values()) {
            if (c.getValue().equals(value)) {
                return c.code;
            }
        }
        return null;
    }

}
