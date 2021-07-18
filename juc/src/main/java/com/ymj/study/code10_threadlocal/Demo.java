package com.ymj.study.code10_threadlocal;

/**
 * @author : yemingjie
 * @date : 2021/7/17 18:23
 */
public class Demo {

    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        magicHash(16);
        magicHash(32);
    }

    private static void magicHash(int size) {
        int hashcode = 0;
        for (int i = 0; i < size; i++) {
            hashcode = i * HASH_INCREMENT + HASH_INCREMENT;
            System.out.print((hashcode & (size - 1)) + " ");
        }
        System.out.println();
    }
}
