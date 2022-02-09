package com.master.common.utils;

import com.master.common.constant.StringPoolConstant;
import com.master.common.validator.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通用处理工具类
 *
 * @author: hxiang
 * @date: 2019/8/28
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
@Slf4j
public class CommonUtil {

    private static final char[] DIGIT = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 根据时间戳生成交易单号
     *
     * @param shopId 店铺id
     * @param type   0：退款 1：支付 2:查询
     * @return 32位商户单号:20210615154740140470716103616151
     */
    public static String getTransactionNumber(int type) {
        String str = DateUtil.getCurrentDateTimeShort();
        StringBuffer sb = new StringBuffer();
        sb.append(str).append(String.valueOf(SnowFlakeUtil.snowflakeId()).substring(0, 16));
        int sum = 0;
        for (int i = 0; i < sb.length(); i++) {
            sum = sum + Integer.valueOf(sb.substring(i, i + 1));
        }
        int s = sum % 9;
        sb.append(s).append(type);
        return sb.toString().trim();
    }

    /**
     * 根据时间戳生成内部合同号
     *
     * @param param 开头 合同号 ：2位首字母
     * @return 后台单号: 例如 调拨：DB2003071055270759
     */
    public static String getContractNumber(String param) {
        String str = DateUtil.formatLocalDateTime(LocalDateTime.now(), "yyyyMMddHHmm");
        StringBuffer sb = new StringBuffer();
        sb.append(param).append(str).append(RandomUtil.randomNumbers(4));
        return sb.toString().trim();
    }

    /**
     * 截取字符串
     *
     * @param str 字符串
     * @param len 长度
     * @return
     */
    public static String subStr(String str, Integer len) {
        if (str == null) {
            return StringPoolConstant.EMPTY;
        }
        Integer lg = str.length();
        if (len > lg) {
            return str.substring(0, lg);
        } else {
            return str.substring(0, len);
        }
    }

    /**
     * 将特定字符串分割的参数转成数组
     *
     * @param str   字符串
     * @param param 分割参数
     * @return
     */
    public static List<Integer> fromStringToList(String str) {
        return fromStringToList(str, StringPoolConstant.COMMA);
    }

    /**
     * 将特定字符串分割的参数转成数组
     *
     * @param str   字符串
     * @param param 分割参数
     * @return
     */
    public static List<Integer> fromStringToList(String str, String param) {
        if (ValidatorUtil.isNull(str)) {
            return new ArrayList<>();
        }
        String[] rsIds = str.split(param);
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < rsIds.length; i++) {
            ids.add(Integer.parseInt(rsIds[i]));
        }
        return ids;
    }

    /**
     * 将特定字符串分割的参数转成数组
     *
     * @param str 字符串
     * @return
     */
    public static List<String> fromStringToListStr(String str) {
        return fromStringToListStr(str, StringPoolConstant.COMMA);
    }

    /**
     * 将特定字符串分割的参数转成数组
     *
     * @param str 字符串
     * @return
     */
    public static List<String> fromStringToListStr(String str, String param) {
        if (ValidatorUtil.isNull(str)) {
            return new ArrayList<>();
        }
        String[] rsIds = str.split(param);
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < rsIds.length; i++) {
            ids.add(rsIds[i]);
        }
        return ids;
    }

    /**
     * 将特点字符串分割的参数转成数组
     *
     * @param arr 数组
     * @return 字符串
     */
    public static String fromListToString(List<Integer> arr) {
        String ids = arr.toString();
        ids = ids.substring(1, ids.length() - 1).replaceAll("\\s*", StringPoolConstant.EMPTY);
        return ids;
    }


    /**
     * 字符串正则匹配
     *
     * @param p
     * @param str
     * @return
     */
    public static String matchResult(Pattern p, String str) {
        StringBuilder sb = new StringBuilder();
        Matcher m = p.matcher(str);
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                sb.append(m.group());
            }
        }
        return sb.toString();
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray 字节数组
     * @return
     */
    static String byteToStr(byte[] byteArray) {
        String strDigest = StringPoolConstant.EMPTY;
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte 字节
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] tempArr = new char[2];
        tempArr[0] = DIGIT[(mByte >>> 4) & 0X0F];
        tempArr[1] = DIGIT[mByte & 0X0F];
        String item = new String(tempArr);
        return item;
    }

}
