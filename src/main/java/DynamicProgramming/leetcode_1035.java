package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/26
 */
public class leetcode_1035 {
  /*
  两个数组 用int[][] dp
  dp[i][j]的含义是 在[0,i]和[0,j]最多有多少条线
   */
  public static int maxUncrossedLines(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int[][] dp = new int[m][n];
    int mFlag = 0;
    //初始化
    for (int i = 0; i < m; i++) {
      if (mFlag == 1 || nums1[i] == nums2[0]) {
        dp[i][0] = 1;
        mFlag = 1;
      }
    }
    mFlag = 0;
    for (int i = 0; i < n; i++) {
      if (mFlag == 1 || nums1[0] == nums2[i]) {
        dp[0][i] = 1;
        mFlag = 1;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (nums1[i] == nums2[j]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 3, 7, 1, 7, 5};
    int[] nums2 = {1,9,2,5,1};
    System.out.println(maxUncrossedLines(nums1, nums2));
  }
}
