package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/4/29
 */
public class leetcode_474 {

  public static int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    dp[0][0] = 0;
    for (String str : strs) {
      int x = 0;
      int y = 0;
      char[] chars = str.toCharArray();
      for (char aChar : chars) {
        if (aChar == '0') {
          x++;
        } else {
          y++;
        }
      }
      for (int i = m; i >= x; i--) {
        for (int j = n; j >= y; j--) {
          dp[i][j] = Math.max(dp[i][j], dp[i - x][j - y] + 1);
        }
      }
    }
    return dp[m][n];
  }
  public static void main(String[] args) {
    String[] str = {"10","0","1"};
    System.out.println(findMaxForm(str, 1, 1));
  }
}
