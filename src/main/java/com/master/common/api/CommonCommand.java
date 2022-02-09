package com.master.common.api;

import java.io.Serializable;

/**
 * 整个应用通用的Command
 *
 * @author: Yang
 * @date: 2020/12/8
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
public class CommonCommand implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作人
     */
    private String operater;

    /**
     * 操作人Id
     */
    private Long operaterId;

    /**
     * 是否需要操作人
     */
    private boolean needsOperator;

    public String getOperater() {
        return this.operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
        needsOperator = true;
    }

    public void setOperaterId(Long operaterId) {
        this.operaterId = operaterId;
        needsOperator = true;
    }

    public Long getOperaterId() {
        return this.operaterId;
    }

    public boolean isNeedsOperator() {
        return needsOperator;
    }

}
