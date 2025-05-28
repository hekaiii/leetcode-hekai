package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/28
 */
public class leetcode_115 {
  public static int numDistinct(String s, String t) {
    char[] s1 = s.toCharArray(); //i
    char[] s2 = t.toCharArray(); //j
    int[][] dp = new int[s1.length + 1][s2.length + 1];
    //初始化
    for (int i = 0; i <= s1.length; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i <= s1.length; i++) {
      for (int j = 1; j <= s2.length; j++) {
        if (s1[i-1] == s2[j-1]) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[s1.length][s2.length];
  }

  public static void main(String[] args) {
    System.out.println(numDistinct("babgbag","bag"));
  }
}
