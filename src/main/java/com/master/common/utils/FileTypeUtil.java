package com.master.common.utils;

import com.master.common.constant.StringPoolConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 文件类型转换工具类
 *
 * @author: Yang
 * @date: 2020/12/9
 * @version: 1.0.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
public class FileTypeUtil {

    /**
     * buf to InputStream
     *
     * @param buf
     * @return
     */
    public static final InputStream byte2Input(byte[] buf) {
        return new ByteArrayInputStream(buf);
    }

    /**
     * inStream to byte[]
     *
     * @param inStream
     * @return
     * @throws IOException
     */
    public static final byte[] input2byte(InputStream inStream) {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc;
        try {
            while ((rc = inStream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }


    /**
     * MultipartFile2File
     *
     * @param multipartFile
     * @return
     */
    private static File transferToFile(MultipartFile multipartFile) {
        //选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferto()方法 。
        File file = null;
        try {
            //获取文件名
            String originalFilename = multipartFile.getOriginalFilename();
            //获取最后一个"."的位置
            int cutPoint = originalFilename.lastIndexOf(StringPoolConstant.DOT);
            //获取文件名
            String prefix = originalFilename.substring(0, cutPoint);
            //获取后缀名
            String suffix = originalFilename.substring(cutPoint + 1);
            //创建临时文件
            file = File.createTempFile(prefix, suffix);
            //multipartFile2file
            multipartFile.transferTo(file);
            //删除临时文件
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 获取文件类型
     * <p>
     * 例如: 文章.txt, 返回: txt
     *
     * @param file 文件名
     * @return 后缀（不含".")
     */
    public static String getFileType(File file) {
        if (null == file) {
            return StringUtils.EMPTY;
        }
        return getFileType(file.getName());
    }

    /**
     * 获取文件类型
     * <p>
     * 例如: 文章.txt, 返回: txt
     *
     * @param fileName 文件名
     * @return 后缀（不含".")
     */
    public static String getFileType(String fileName) {
        int separatorIndex = fileName.lastIndexOf(StringPoolConstant.DOT);
        if (separatorIndex < 0) {
            return StringPoolConstant.EMPTY;
        }
        return fileName.substring(separatorIndex + 1).toLowerCase();
    }

    /**
     * 获取文件类型
     *
     * @param photoByte 文件字节码
     * @return 后缀（不含".")
     */
    public static String getFileExtendName(byte[] photoByte) {
        String strFileExtendName = "JPG";
        if ((photoByte[0] == 71) && (photoByte[1] == 73) && (photoByte[2] == 70) && (photoByte[3] == 56)
                && ((photoByte[4] == 55) || (photoByte[4] == 57)) && (photoByte[5] == 97)) {
            strFileExtendName = "GIF";
        } else if ((photoByte[6] == 74) && (photoByte[7] == 70) && (photoByte[8] == 73) && (photoByte[9] == 70)) {
            strFileExtendName = "JPG";
        } else if ((photoByte[0] == 66) && (photoByte[1] == 77)) {
            strFileExtendName = "BMP";
        } else if ((photoByte[1] == 80) && (photoByte[2] == 78) && (photoByte[3] == 71)) {
            strFileExtendName = "PNG";
        }
        return strFileExtendName;
    }

}