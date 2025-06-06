package DynamicProgramming;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-04-10 07:22:57
 */
public class leetcode_509 {
  public int fib(int n) {
    if (n < 2) {
      return n;
    }
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public static int fib01(int n) {
    if (n < 2) {
      return n;
    }
    int[] dp = new int[n+1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
  public static void main(String[] args) {
    System.out.println(fib01(4));
  }
}
