package com.master.common.utils;

import com.master.common.api.Tree;
import com.master.common.enums.IntegerEnum;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 树形结构递归处理类
 *
 * @author: Yang
 * @date: 2023/12/24
 * @version: 1.0.0
 * https://www.panday94.xyz
 * Copyright Ⓒ 2023 熊扬软件开发工作室 Limited All rights reserved.
 */
public class TreeUtil {

    private static final String PID = "parentId";
    private static final String ID = "id";
    private static final String CHILDREN = "children";

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

    /**
     * 递归方法
     * 必须有参数parentId和children
     *
     * @param cs 泛型
     * @return
     */
    public static <T, S> List<T> tree(List<S> source, Class<T> cs) {
        List<T> trees = DozerUtil.convertor(source, cs);
        //获取父节点
        List<T> collect = trees.stream().filter(m -> {
            try {
                Field field = m.getClass().getDeclaredField(PID);
                field.setAccessible(true);
                return Integer.valueOf(field.get(m).toString()).equals(IntegerEnum.ZERO.getValue());
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }).map(
                (m) -> {
                    try {
                        Field field = m.getClass().getDeclaredField(CHILDREN);
                        field.setAccessible(true);
                        field.set(m, getChildrens(m, trees));
                        return m;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
    private static <T> List<T> getChildrens(T t, List<T> all) {
        List<T> children = all.stream().filter(m -> {
            try {
                Field field = m.getClass().getDeclaredField(PID);
                field.setAccessible(true);
                Field fieldt = t.getClass().getDeclaredField(ID);
                fieldt.setAccessible(true);
                return Objects.equals(field.get(m), fieldt.get(t));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }).map(
                (m) -> {
                    try {
                        Field field = m.getClass().getDeclaredField(CHILDREN);
                        field.setAccessible(true);
                        field.set(m, getChildrens(m, all));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }

}
