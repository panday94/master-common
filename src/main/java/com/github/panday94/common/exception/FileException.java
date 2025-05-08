package com.github.panday94.common.exception;

import com.github.panday94.common.enums.ResponseEnum;
import lombok.Data;

/**
 * 文件处理异常
 *
 * @author: Yang
 * @date: 2023/3/4
 * @version: 3.0.0
 * https://www.panday94.xyz
 * Copyright Ⓒ 2023 熊扬软件开发工作室 Limited All rights reserved.
 */
@Data
public class FileException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;

    public FileException() {
        this.code = ResponseEnum.FILE_ERROR.getCode();
        this.msg = ResponseEnum.FILE_ERROR.getMsg();
    }

    public FileException(String msg) {
        super(msg);
        this.code = ResponseEnum.FILE_ERROR.getCode();
        this.msg = msg;
    }

}
