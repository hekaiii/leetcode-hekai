package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/29
 */
public class leetcode_72 {
  public static int minDistance(String word1, String word2) {
    if (word1.length() == 0 || word2.length() == 0) {
      return word1.length() == 0 ? word2.length() : word1.length();
    }
    //dp[i][j]的含义 数组i和数组j中 需要变得一致 需要操作dp[i][j]次
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 1; i <= word1.length(); i++) {
      dp[i][0] = i;
    }
    for (int i = 1; i <= word2.length(); i++) {
      dp[0][i] = i;
    }
    for (int i = 1; i <=word1.length(); i++) {
      for (int j = 1; j <=word2.length(); j++) {
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }

  public static void main(String[] args) {
    System.out.println(minDistance("intention","execution"));
  }
}
