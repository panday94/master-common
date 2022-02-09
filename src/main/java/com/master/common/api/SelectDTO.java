package com.master.common.api;

import lombok.Data;

import java.io.Serializable;

/**
 * 下拉选择内容
 *
 * @author: Yang
 * @date: 2021/8/30
 * @version: 1.2.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Data
public class SelectDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String name;

    /**
     * 字典值
     */
    private String value;

}
