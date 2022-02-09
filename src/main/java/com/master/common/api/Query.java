package com.master.common.api;

import com.master.common.constant.StringPoolConstant;
import com.master.common.enums.IntEnum;
import com.master.common.exception.ValidateException;
import com.master.common.validator.ValidatorUtil;
import com.master.common.validator.base.BaseAssert;
import com.master.common.xss.SQLFilter;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 公共查询参数
 *
 * @author: hxiang
 * @date: 2021/8/17
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Data
public class Query extends LinkedHashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    private Long page;
    /**
     * 每页条数
     */
    private Long limit;

    /**
     * 主键
     */
    private Long id;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 开始时间  yyyy-MM-dd HH:mm:ss
     */
    private String startTime;

    /**
     * 结束时间 yyyy-MM-dd HH:mm:ss
     */
    private String endTime;

    /**
     * 开始日期 yyyy-MM-dd
     */
    private String startDate;

    /**
     * 结束日期 yyyy-MM-dd
     */
    private String endDate;

    /**
     * 名称
     */
    private String name;

    /**
     * 手机号
     */
    private String tel;

    public Query() {
    }

    public Query(Map<String, Object> params) {
        this.putAll(params);
        //分页参数
        this.page = ValidatorUtil.isNotNull(params.get("page")) ? Long.valueOf(params.get("page").toString()) : null;
        this.limit = ValidatorUtil.isNotNull(params.get("limit")) ? Long.valueOf(params.get("limit").toString()) : null;
        this.id = ValidatorUtil.isNotNull(params.get("id")) ? Long.valueOf(params.get("id").toString()) : null;
        this.status = ValidatorUtil.isNotNull(params.get("status")) ? Integer.valueOf(params.get("status").toString()) : null;
        this.type = ValidatorUtil.isNotNull(params.get("type")) ? Integer.valueOf(params.get("type").toString()) : null;
        this.startTime = BaseAssert.getParamOrElse(params, "startTime");
        this.endTime = BaseAssert.getParamOrElse(params, "endTime");
        this.startDate = BaseAssert.getParamOrElse(params, "startDate");
        this.endDate = BaseAssert.getParamOrElse(params, "endDate");
        this.name = BaseAssert.getParamOrElse(params, "name");
        this.tel = BaseAssert.getParamOrElse(params, "tel");
        if (ValidatorUtil.isNotNull(this.startDate) && this.startDate.length() == IntEnum.TEN.getValue()) {
            this.startDate = this.startDate + " 00:00:00";
        }
        if (ValidatorUtil.isNotNull(this.endDate) && this.endDate.length() == IntEnum.TEN.getValue()) {
            this.endDate = this.endDate + " 23:59:59";
        }
        if (ValidatorUtil.isNotNull(this.page) && ValidatorUtil.isNotNull(this.limit)) {
            this.put("offset", (page - 1) * limit);
        }
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String sidx = (String) params.get("sidx");
        String order = (String) params.get("order");
        if (StringUtils.isNotBlank(sidx)) {
            this.put("sidx", SQLFilter.sqlInject(sidx));
        }
        if (StringUtils.isNotBlank(order)) {
            this.put("order", SQLFilter.sqlInject(order));
        }

    }

    public Query(Map<String, Object> params, Boolean isPage) {
        if (ValidatorUtil.isNull(params.get(StringPoolConstant.PAGE)) || ValidatorUtil.isNull(params.get(StringPoolConstant.LIMIT))) {
            throw new ValidateException("缺少分页必要参数");
        }
        this.putAll(params);
        //分页参数
        this.page = Long.valueOf(params.get("page").toString());
        this.limit = Long.valueOf(params.get("limit").toString());
        this.id = ValidatorUtil.isNotNull(params.get("id")) ? Long.valueOf(params.get("id").toString()) : null;
        this.type = ValidatorUtil.isNotNull(params.get("type")) ? Integer.valueOf(params.get("type").toString()) : null;
        this.status = ValidatorUtil.isNotNull(params.get("status")) ? Integer.valueOf(params.get("status").toString()) : null;
        this.startTime = BaseAssert.getParamOrElse(params, "startTime");
        this.endTime = BaseAssert.getParamOrElse(params, "endTime");
        this.startDate = BaseAssert.getParamOrElse(params, "startDate");
        this.endDate = BaseAssert.getParamOrElse(params, "endDate");
        this.name = BaseAssert.getParamOrElse(params, "name");
        this.tel = BaseAssert.getParamOrElse(params, "tel");
        this.put("offset", (page - 1) * limit);
        if (ValidatorUtil.isNotNull(this.startDate) && this.startDate.length() == IntEnum.TEN.getValue()) {
            this.startDate = this.startDate + " 00:00:00";
        }
        if (ValidatorUtil.isNotNull(this.endDate) && this.endDate.length() == IntEnum.TEN.getValue()) {
            this.endDate = this.endDate + " 23:59:59";
        }
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String sidx = (String) params.get("sidx");
        String order = (String) params.get("order");
        if (StringUtils.isNotBlank(sidx)) {
            this.put("sidx", SQLFilter.sqlInject(sidx));
        }
        if (StringUtils.isNotBlank(order)) {
            this.put("order", SQLFilter.sqlInject(order));
        }
    }

}
