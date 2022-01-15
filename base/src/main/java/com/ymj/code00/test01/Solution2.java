package com.ymj.code00.test01;

/**
 * 输入:
 * [
 *   [1,3,1,4],
 *   [1,5,1,5],
 *   [4,2,1,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class Solution2 {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1,4}, {1,5,1,5}, {4,2,1,1}};
        int i = maxValue(grid);
        System.out.println(i);
    }

    public static int maxValue(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i-1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m- 1][n - 1];
    }
}
