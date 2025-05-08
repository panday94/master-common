package com.github.panday94.common.api;

import lombok.Data;

import java.util.List;

/**
 * 基础用户信息
 *
 * @author: Yang
 * @date: 2023/12/8
 * @version: 1.0.0
 * https://www.panday94.xyz
 * Copyright Ⓒ 2023 熊扬软件开发工作室 Limited All rights reserved.
 */
@Data
public class LoginUser {

    /**
     * 对应数据库主键id
     */
    private Long id;

    /**
     * 失效时间（秒）
     */
    private Long exp;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 生成token唯一标识
     */
    private String jti;

    /**
     * 对应客户端id
     */
    private String clientId;

    /**
     * 权限
     */
    private List<String> scope;

    /**
     * 权限
     */
    private List<String> authorities;

}
