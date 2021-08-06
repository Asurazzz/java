package com.ymj.code03_filechannel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @Classname GetTest
 * @Description TODO
 * @Date 2021/8/6 11:04
 * @Created by yemingjie
 */
public class GetTest {
    public static void main(String[] args) throws FileNotFoundException {
        String srcFile = "";
        String destFile = "";

        //创建一个文件输入流
        FileInputStream fis = new FileInputStream(srcFile);
        //获取文件流的通道
        FileChannel inChannel = fis.getChannel();

        //创建一个文件输出流
        FileOutputStream fos = new FileOutputStream(destFile);
        //获取文件流的通道
        FileChannel outchannel = fos.getChannel();
    }
}
