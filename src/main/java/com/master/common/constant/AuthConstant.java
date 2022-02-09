package com.master.common.constant;

/**
 * 鉴权常量
 *
 * @author: Yang
 * @date: 2020/11/17
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
public interface AuthConstant {

    /**
     * JWT存储权限前缀
     */
    String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * 认证信息Http请求头
     */
    String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT令牌前缀
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * JWT载体key
     */
    String JWT_PAYLOAD_KEY = "payload";

    /**
     * 密码加密方式
     */
    String ENCODE = "encode";

    /**
     * 密码加密方式
     */
    String BCRYPT = "{bcrypt}";

    /**
     * 密码加密方式(不加密)
     */
    String NOOP = "{noop}";

    /**
     * jwt客户端id
     */
    String CLIENT_ID_KEY = "client_id";

    /**
     * jwt登录用户id
     */
    String USERID_KEY = "id";

    /**
     * jwt登录客户端id
     */
    String CLIENTID_KEY = "clientId";

    /**
     * jwt登录用户名
     */
    String USERNAME_KEY = "userName";

    /**
     * JWT唯一标识
     */
    String JTI = "jti";

    /**
     * JWT过期时间戳
     */
    String EXP = "exp";

    /**
     * 登录token
     */
    String TOKEN = "token";

}
