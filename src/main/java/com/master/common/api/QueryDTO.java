package com.master.common.api;

import lombok.Data;

import java.io.Serializable;

/**
 * 公共查询DTO
 *
 * @author: Yang
 * @date: 2021/6/28
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Data
public class QueryDTO implements Serializable {

    private static final long serialVersionUID = -7087813491172330937L;

    private Long id;

    /**
     * 当前页号
     */
    private Long page;

    /**
     * 页数
     */
    private Long limit;

    /**
     * 开始时间  yyyy-MM-dd HH:mm:ss
     */
    private String startTime;

    /**
     * 结束时间 yyyy-MM-dd HH:mm:ss
     */
    private String endTime;

    /**
     * 开始日期 yyyy-MM-dd
     */
    private String startDate;

    /**
     * 结束日期 yyyy-MM-dd
     */
    private String endDate;

    /**
     * 名称
     */
    private String name;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 类型
     */
    private Integer type;

}
