package com.master.common.exception;

import com.master.common.enums.ResponseEnum;
import lombok.Data;

/**
 * 系统预警异常
 *
 * @author: Yang
 * @date: 2020/3/4
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Data
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;

    public SystemException() {
        this.code = ResponseEnum.SYSTEM_WARNING.getCode();
        this.msg = ResponseEnum.SYSTEM_WARNING.getMsg();
    }

    public SystemException(String msg) {
        super(msg);
        this.code = ResponseEnum.SYSTEM_WARNING.getCode();
        this.msg = msg;
    }

}
