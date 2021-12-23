package com.ymj.code00.test01;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，
 * 11 翻译成 “l”，……，25翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * 1,2,2,5,8
 * 1,2,25,8
 * 1, 22, 5, 8
 * 12,2,5,8
 * 12,25,8
 *
 * @author admin
 */
public class Solution {

    public static void main(String[] args) {

        int i = translateNum(12248);
        System.out.println(i);
    }
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? (a + b) : a;
            b = a;
            a = c;
        }
        return a;
    }
}
