package com.master.common.exception;

import com.master.common.enums.ResponseEnum;
import lombok.Data;

/**
 * 文件处理异常
 *
 * @author: hxiang
 * @date: 2020/3/4
 * @version: 3.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Data
public class FileException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;

    public FileException() {
        this.code = ResponseEnum.BUSINESS_ERROR.getCode();
        this.msg = ResponseEnum.BUSINESS_ERROR.getMsg();
    }

    public FileException(String msg) {
        super(msg);
        this.code = ResponseEnum.BUSINESS_ERROR.getCode();
        this.msg = msg;
    }

}
