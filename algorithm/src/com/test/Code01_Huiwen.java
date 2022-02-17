package com.test;

/**
 * 求用十进制、二进制、八进制表示都是回
 * 文数的所有数字中，大于十进制数 10 的最
 * 小值。
 */
public class Code01_Huiwen {
    // 思路：因为是二进制的回文数，如果最低位是0，那么最高位也是0，但是以0开始肯定是不恰当的
    // 由此可知最低位是1。二进制表示的最低位是1，那么就是奇数，所以只用考虑奇数即可
    public static void main(String[] args) {
        int num = 11;
        while (true) {
            if (Integer.parseInt(String.valueOf(num)) == Integer.parseInt(new StringBuffer(String.valueOf(num)).reverse().toString())
                    && Integer.parseInt(Integer.toBinaryString(num)) == Integer.parseInt(new StringBuffer(Integer.toBinaryString(num)).reverse().toString())
                    && Integer.parseInt(Integer.toOctalString(num)) == Integer.parseInt(new StringBuffer(Integer.toOctalString(num)).reverse().toString())) {

                System.out.println(num);
                System.out.println(Integer.toBinaryString(num) + "---" + Integer.parseInt(new StringBuffer(Integer.toBinaryString(num)).reverse().toString()));
                System.out.println(Integer.parseInt(Integer.toOctalString(num)) + "---" + Integer.parseInt(new StringBuffer(Integer.toOctalString(num)).reverse().toString()));
                break;
            }
            num += 2;
        }
    }
}
