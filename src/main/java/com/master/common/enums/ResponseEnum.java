package com.master.common.enums;

import lombok.Getter;

/**
 * 全局返回参数
 *
 * @author: Yang
 * @date: 2020/8/6
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Getter
public enum ResponseEnum {

    /**
     * 操作成功（有返回内容）
     */
    SUCCESS(200, "操作成功"),
    /**
     * 操作成功（无返回内容）
     */
    SUCCESS_NODATE(204, "操作成功"),
    BAD_REQUEST(400, "参数错误"),
    PROHIBIT_VISIT(401, "账号认证失败，请重新登录"),
    PERMISSION_DENIED(403, "权限不足，无法操作"),
    RESOURCES_ERROR(404, "访问资源丢失，请升级相应版本或检查请求路径"),
    NO_LOGIN(405, "未登录"),
    SING_ERROR(406, "签名验证失败"),
    REQUEST_METHOD_ERROR(407, "啊哟，请求方式错了哦，请确认API请求方式GET/POST/PUT/DELETE"),
    CONNECT_TIME_OUT(408, "连接超时啦，请稍后再试哦"),
    TOO_MANY_REQUESTS(429, "请求未受理，请降低频率后重试"),
    ERROR(500, "系统升级中，请稍后再试"),

    ACCOUNT_NOT_EXIST(501, "账号不存在，请联系客服"),
    PASSWORD_ERROR(502, "账号密码错误，请联系客服"),
    ACCOUNT_IS_DISABLED(503, "账号已被禁用，请联系客服"),
    TEL_IS_EXIST(504, "手机号已经注册"),
    NAME_IS_EXIST(506, "用户名已存在"),
    REPEAT_REQUEST_SMS(505, "验证码有限期为5分钟，无需重复获取"),
    PHONE_BINDING(507, "请绑定手机号"),
    ACCOUNT_LOGIN_EXIST(508, "该账号已在其他地方登录，请重新登录"),

    /**
     * 业务异常
     */
    BUSINESS_ERROR(600, "业务出错，请联系客服"),

    /**
     * 系统预警，需及时处理
     */
    SYSTEM_WARNING(601, "系统预警，请及时处理"),

    FILE_ERROR(602, "文件处理失败，请稍后再试");

    private final Integer code;
    private final String msg;

    ResponseEnum(final Integer code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

}
