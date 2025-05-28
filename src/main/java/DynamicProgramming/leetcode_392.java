package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/27
 */
public class leetcode_392 {
  public static boolean isSubsequence(String s, String t) {
    char[] c1 = s.toCharArray();
    char[] c2 = t.toCharArray();
    int[][] dp = new int[c1.length + 1][c2.length + 1];
    for (int i = 1; i <= c1.length; i++) {
      for (int j = 1; j <= c2.length; j++) {
        if (c1[i-1] == c2[j-1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    if (dp[c1.length][c2.length] == c1.length) {
      return true;
    }
    return false;
  }

  public static boolean isSubsequence01(String s, String t) {
    int i = 0, j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    if (i == s.length()) {
      return true;
    }
    return false;
  }
  public static void main(String[] args) {
    System.out.println(isSubsequence01("abc", "ahbgdc"));
  }
}
