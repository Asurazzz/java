package com.ymj.c2.hashtest;

import java.util.HashMap;

public class ExceptionTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("1", "1");
        hashMap.put("2", "2");

        for (String key : hashMap.keySet()) {
            if ("1".equals(key)) {
                hashMap.remove(key);
            }
        }
    }
}
