package com.master.common.exception;

import com.master.common.enums.ResponseEnum;
import lombok.Data;

/**
 * 自定义抛出异常
 *
 * @author: Yang
 * @date: 2023/3/4
 * @version: 1.0.0
 * https://www.panday94.xyz
 * Copyright Ⓒ 2023 曜栋网络科技工作室 Limited All rights reserved.
 */
@Data
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;

    public CustomException() {
        this.code = ResponseEnum.ERROR.getCode();
        this.msg = ResponseEnum.ERROR.getMsg();
    }

    public CustomException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CustomException(ResponseEnum responseEnum) {
        super(responseEnum.getMsg());
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }

}
