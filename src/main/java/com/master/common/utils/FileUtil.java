package com.master.common.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 文件工具类
 *
 * @author: Yang
 * @date: 2021/9/15
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
public class FileUtil {

    /**
     * 以流的形式下载文件
     *
     * @param response
     * @param path     文件路径
     * @return
     */
    public static HttpServletResponse download(HttpServletResponse response, String path) {
        // path是指欲下载的文件的路径。
        File file = new File(path);
        try {
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, MediaType.ALL.getType());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            file.delete();
        }
        return response;
    }

    /**
     * 下载本地文件
     *
     * @param response
     * @param path     文件存储路径
     */
    public static void downloadLocal(HttpServletResponse response, String path) {
        // 读到流中
        // 文件的存放路径
        // path是指欲下载的文件的路径。
        File file = new File(path);
        InputStream inStream = null;
        try {
            inStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0) {
                response.getOutputStream().write(b, 0, len);
            }
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.delete();
        }
    }

    /**
     * 下载网络url文件
     *
     * @param response
     * @param netUrl   网络地址
     * @param filename 文件存储本地地址
     * @throws MalformedURLException
     */
    public void downloadNet(HttpServletResponse response, String netUrl, String filename) throws MalformedURLException {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;
        URL url = new URL(netUrl);
        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(filename);
            byte[] buffer = new byte[1204];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
