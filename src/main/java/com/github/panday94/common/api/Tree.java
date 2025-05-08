package com.github.panday94.common.api;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 树形结构
 *
 * @author: Yang
 * @date: 2023/12/8
 * @version: 1.0.0
 * https://www.panday94.xyz
 * Copyright Ⓒ 2023 熊扬软件开发工作室 Limited All rights reserved.
 */
@Data
public class Tree implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 节点路径
     */
    private String path;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 类目图片
     */
    private String icon;

    /**
     * 排序
     */
    private Integer rank;


    /**
     * 子类
     */
    private List<Tree> children;

}
