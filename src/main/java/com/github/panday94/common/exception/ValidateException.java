package com.github.panday94.common.exception;

import com.github.panday94.common.enums.ResponseEnum;
import lombok.Data;

/**
 * 参数验证失败异常
 *
 * @author: Yang
 * @date: 2023/3/4
 * @version: 1.0.0
 * https://www.panday94.xyz
 * Copyright Ⓒ 2023 熊扬软件开发工作室 Limited All rights reserved.
 */
@Data
public class ValidateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;

    public ValidateException() {
        this.code = ResponseEnum.BAD_REQUEST.getCode();
        this.msg = ResponseEnum.BAD_REQUEST.getMsg();
    }

    public ValidateException(String msg) {
        super(msg);
        this.code = ResponseEnum.BAD_REQUEST.getCode();
        this.msg = msg;
    }

}
