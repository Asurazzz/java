package com.ymj.study01;

import javax.crypto.KeyGenerator;

public class TestApp {
    private static final int MAX_ENCRYPT_BLOCK = 117;
    //算法
    public static final String KEY_ALGORITHM = "RSA";
    //RSA最大解密密文大小
    private static final int MAX_DECRYPT_BLOCK = 128;
    //签名算法
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private KeyGenerator keygen;
}
