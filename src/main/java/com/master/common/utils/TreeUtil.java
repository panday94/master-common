package com.master.common.utils;

import com.master.common.api.Tree;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 树形结构递归处理类
 *
 * @author: Yang
 * @date: 2020/12/24
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
public class TreeUtil {

    /**
     * 递归方法
     *
     * @param cs
     * @return
     */
    public static List<Tree> tree(List<?> source) {
        List<Tree> trees = DozerUtil.convertor(source, Tree.class);
        //获取父节点
        List<Tree> collect = trees.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildren(getChildrens(m, trees));
                    return m;
                }
        ).collect(Collectors.toList());
        return collect;

    }

    /**
     * 获取当前节点的所有子节点
     *
     * @param pid
     * @param cs
     * @return
     */
    private static List<Tree> getChildrens(Tree root, List<Tree> all) {
        List<Tree> children = all.stream().filter(m -> {
            return Objects.equals(m.getParentId(), root.getId());
        }).map(
                (m) -> {
                    m.setChildren(getChildrens(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }

}
