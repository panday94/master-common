package com.master.common.utils;

import com.master.common.enums.ResponseEnum;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

/**
 * 图片工具类
 *
 * @author: Yang
 * @date: 2021/10/23
 * @version: 1.2.0
 * Copyright Ⓒ 2021 Master Computer Corporation Limited All rights reserved.
 */
public class ImageUtil {

    /**
     * 文件地址
     */
    public static final String PATH = "/usr/local/src/upload/";


    /**
     * Base编码前缀 jpg
     */
    private static final String JPG_PREFIX = "data:image/jpeg;base64,";

    /**
     * Base编码前缀png
     */
    private static final String PNG_PREFIX = "data:image/png;base64,";

    /**
     * 本地文件（图片、excel等）转换成Base64字符串
     *
     * @param imgPath 文件路径
     */
    public static String convertFileToBase64(File file) {
        return convertFileToBase64(FileUtil.getInputStream(file));
    }

    /**
     * 本地文件（图片、excel等）转换成Base64字符串
     *
     * @param imgPath 文件路径
     */
    public static String convertFileToBase64(String imgPath) {
        try {
            InputStream in = new FileInputStream(imgPath);
            return convertFileToBase64(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 本地文件（图片、excel等）转换成Base64字符串
     *
     * @param imgPath 文件路径
     */
    public static String convertFileToBase64(InputStream in) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组进行Base64编码，得到Base64编码的字符串
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Str = encoder.encode(data);
        return base64Str;
    }

    /**
     * 将base64字符串，生成文件
     *
     * @param base64   base64文件
     * @param filePath 文件存储路径
     * @param fileName 文件名称
     */
    public static File convertBase64ToFile(String base64, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file;
        try {
            File dir = new File(filePath);
            //判断文件目录是否存在
            if (!dir.exists() && dir.isDirectory()) {
                dir.mkdirs();
            }

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bfile = decoder.decodeBuffer(base64);

            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 远程图片转File
     *
     * @param url     图片链接
     * @param outPath 输出地址
     * @return
     */
    public static File convertUrlToFile(String url, String filePath, String fileName) {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            if (conn.getResponseCode() != ResponseEnum.SUCCESS.getCode().intValue()) {
                return null;
            }
            File file = new File(filePath + fileName);
            InputStream is = conn.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            FileOutputStream os = new FileOutputStream(file, true);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            os.close();
            is.close();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            conn.disconnect();
        }
    }


    /**
     * 远程图片转BufferedImage
     *
     * @param url     图片链接
     * @param outPath 输出地址
     * @return
     */
    public static BufferedImage convertUrlToBufferedImage(String url, String filePath, String fileName) {
        File file = convertUrlToFile(url, filePath, fileName);
        BufferedImage bufferedImg = toBufferedImage(file.getPath());
        return bufferedImg;
    }

    /**
     * 添加水印文件
     *
     * @param buffImg  源文件(BufferedImage)
     * @param waterImg 水印文件(BufferedImage)
     * @param x        距离右下角的X偏移量
     * @param y        距离右下角的Y偏移量
     * @param alpha    透明度, 选择值从0.0~1.0: 完全透明~完全不透明
     */
    public static InputStream overlyingImage(BufferedImage buffImg, BufferedImage waterImg, int x, int y, float alpha)
            throws IOException {
        String filename = UUID.randomUUID().toString() + ".jpg";
        // 创建Graphics2D对象，用在底图对象上绘图
        Graphics2D g2d = buffImg.createGraphics();
        // 获取层图的宽度
        int waterImgWidth = waterImg.getWidth();
        // 获取层图的高度
        int waterImgHeight = waterImg.getHeight();
        // 在图形和图像中实现混合和透明效果
        //g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        // 绘制
        g2d.drawImage(waterImg, x, y, waterImgWidth, waterImgHeight, null);
        // 释放图形上下文使用的系统资源
        g2d.dispose();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(buffImg, "jpg", os);
        InputStream input = new ByteArrayInputStream(os.toByteArray());
        return input;
    }


    /**
     * 读取图片流处理ICC 防止图片颜色异常
     *
     * @param path  图片地址
     * @param image
     */
    private static BufferedImage toBufferedImage(String path) {
        Image image = Toolkit.getDefaultToolkit().getImage(path);
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }
        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        try {
            int transparency = Transparency.OPAQUE;
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null),
                    image.getHeight(null), transparency);
        } catch (HeadlessException e) {
            // The system does not have a screen
        }
        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            bimage = new BufferedImage(image.getWidth(null),
                    image.getHeight(null), type);
        }
        // Copy image to buffered image
        Graphics g = bimage.createGraphics();
        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bimage;
    }

    /**
     * 设置图片大小
     **/
    private static BufferedImage resize(int targetWidth, int targetHeight, BufferedImage src) {
        double scaleW = (double) targetWidth / (double) src.getWidth();
        double scaleH = (double) targetHeight / (double) src.getHeight();
        double scale = scaleW < scaleH ? scaleW : scaleH;
        BufferedImage result = new BufferedImage((int) (src.getWidth() * scale),
                (int) (src.getHeight() * scale), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = result.createGraphics();
        g2d.drawImage(src, 0, 0, result.getWidth(), result.getHeight(), null);
        g2d.dispose();
        return result;
    }

}
