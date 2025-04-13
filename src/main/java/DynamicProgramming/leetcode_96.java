package DynamicProgramming;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-04-13 21:37:28
 */
public class leetcode_96 {
  public static int numTrees(int n) {
    if (n < 3) {
      return n;
    }
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    for ( int i = 3; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] == 0 || dp[i - j - 1] == 0) {
          dp[i] += Math.max(dp[j], dp[i - j - 1]);
        } else {
          dp[i] += dp[j] * dp[i - j - 1];
        }
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(numTrees(5));
  }
}
