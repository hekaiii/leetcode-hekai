package DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/12
 */
public class leetcode_279 {
  public static int numSquares(int n) {
    //dp[j] 含义 装满空间为j的最小平方数为dp[j]个
    int[] dp = new int[n + 1];
    Arrays.fill(dp, 10001);
    dp[0] = 0;
    /**
     * 遍历顺序 先遍历背包还是先遍历物品
     * 背包空间0-n
     * 物品是0~Math.sq(n)
     * 完全背包：1.先包再物品是排列 2.先物品后背包是组合
     */
    int end = (int) Math.sqrt(n);
    for (int i = 1; i <= end; i++) {
      for (int j = i*i; j <= n; j++) {
        dp[j] = Math.min(dp[j], dp[j - i * i]+1);
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(numSquares(15));
  }
}
