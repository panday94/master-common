package com.master.common.enums;

/**
 * 业务操作类型
 *
 * @author: hxiang
 * @date: 2021/10/20
 * @version: 1.2.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
public enum BusinessTypeEnum {

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    GRANT,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 生成代码
     */
    GENCODE,

    /**
     * 清空数据
     */
    CLEAN,

    /**
     * 其它
     */
    OTHER,

}
