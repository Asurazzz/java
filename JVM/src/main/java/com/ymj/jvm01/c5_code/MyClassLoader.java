package com.ymj.jvm01.c5_code;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * @Classname MyClassLoader
 * @Description TODO
 * @Date 2021/8/13 16:53
 * @Created by yemingjie
 */
public class MyClassLoader extends ClassLoader {

    private String codePath;

    public MyClassLoader(ClassLoader parent, String codePath) {
        super(parent);
        this.codePath = codePath;
    }

    public MyClassLoader(String codePath) {
        this.codePath = codePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 1.字节码路径
        String fileName = codePath + name + ".class";
        // 2.获取输入流
        // 3.获取输出流
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            // 4.io读写
            int len;
            byte[] data = new byte[1024];
            while ((len = bis.read(data)) != -1) {
                baos.write(data, 0, len);
            }
            // 5.获取内存中字节数组
            byte[] byteCode = baos.toByteArray();
            // 6.调用defineClass 将字节数组转成Class对象
            Class<?> defineClass = defineClass(null, byteCode, 0, byteCode.length);
            return defineClass;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
