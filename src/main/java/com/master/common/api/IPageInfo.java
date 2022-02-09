package com.master.common.api;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 通用返回分页对象
 *
 * @author: hxiang
 * @date: 2020/11/18
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Data
public class IPageInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    private long current;

    /**
     * 页数
     */
    private long size;

    /**
     * 总数
     */
    private long total;

    /**
     * 结果集
     */
    private List<T> records;

}
