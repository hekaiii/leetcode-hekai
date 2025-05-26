package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/23
 */
public class leetcode_1143 {

  /**
   * dp[][]含义
   *
   * @param text1
   * @param text2
   * @return
   */
  public static int longestCommonSubsequence(String text1, String text2) {
    char[] mlist = text1.toCharArray();
    char[] nlist = text2.toCharArray();
    int m = mlist.length;
    int n = nlist.length;
    int[][] dp = new int[m][n];//m行 n列
    int mIndex = 0;
    int nIndex = 0;
    //初始化
    for (int i = 0; i < m; i++) {
      if (mIndex == 1 || mlist[i] == nlist[0]) {
        dp[i][0] = 1;
        mIndex =1;
      } else {
        dp[i][0] = 0;
      }
    }
    for (int i = 0; i < n; i++) {
      if (nIndex == 1 || nlist[i] == mlist[0]) {
        dp[0][i] = 1;
        nIndex =1;
      } else {
        dp[0][i] = 0;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (mlist[i] == nlist[j]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m-1][n-1];
  }

  public static void main(String[] args) {
    String str1 = "abcde";
    String str2 = "ace";
    System.out.println(longestCommonSubsequence(str1, str2));
  }
}
