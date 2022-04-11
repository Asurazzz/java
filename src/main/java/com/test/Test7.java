package com.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author yemingjie.
 * @date 2022/3/14.
 * @time 14:20.
 */
public class Test7 {
    public static void main(String[] args) {
        String s = "aaa";
        List<String> list = Arrays.asList(s.split(","));
        String c = null;
        if (list.contains("aaa")) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }
    }
}
