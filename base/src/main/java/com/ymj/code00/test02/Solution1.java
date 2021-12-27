package com.ymj.code00.test02;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/27 10:02
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 丑数的递推性质：丑数只包含因子2，3，5，因此有“丑数 = 某较小丑数 * 某因子 （例如：10 = 5 * 2）”
 */
public class Solution1 {
    public static void main(String[] args) {
        int i = nthUglyNumber(7);
        System.out.println(i);
    }
    public static int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}













