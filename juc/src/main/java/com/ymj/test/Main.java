package com.ymj.test;

public class Main {
    public static void main(String[] args) throws Exception {
        String content = "15868861259_1636609895993";        // 原文内容
        String key = "123456";                  // AES加密/解密用的原始密码

        // 加密数据, 返回密文
        byte[] cipherBytes = AESUtils.encrypt(content.getBytes(), key.getBytes());

        System.out.println(cipherBytes.toString());
        // 解密数据, 返回明文
        byte[] plainBytes = AESUtils.decrypt(cipherBytes, key.getBytes());
        // 输出解密后的明文: "Hello world!"
        System.out.println(new String(plainBytes));

    }
}
