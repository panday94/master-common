package com.master.common.exception;

import com.master.common.enums.ResponseEnum;
import lombok.Data;

/**
 * 业务异常
 *
 * @author: Yang
 * @date: 2023/3/4
 * @version: 3.0.0
 * https://www.panday94.xyz
 * Copyright Ⓒ 2023 熊扬软件开发工作室 Limited All rights reserved.
 */
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;

    public BusinessException() {
        this.code = ResponseEnum.BUSINESS_ERROR.getCode();
        this.msg = ResponseEnum.BUSINESS_ERROR.getMsg();
    }

    public BusinessException(String msg) {
        super(msg);
        this.code = ResponseEnum.BUSINESS_ERROR.getCode();
        this.msg = msg;
    }

}
