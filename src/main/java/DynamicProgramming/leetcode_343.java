package DynamicProgramming;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-04-13 20:25:20
 */
public class leetcode_343 {
  public static int integerBreak(int n) {
    if (n == 2) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      for (int j = 1; j <= (i / 2); j++) {
        dp[i] = Math.max(Math.max(j * dp[i - j], j*(i-j)),dp[i]);
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(integerBreak(10));
  }
}
