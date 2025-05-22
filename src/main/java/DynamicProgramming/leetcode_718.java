package DynamicProgramming;

/**
 * @Author: hek32
 * @Description: 两层for循环外层正序 内层倒序 目的是什么
 * 二层倒序的魅力在于，需要使用上一层的记录 并且
 * @Date: 2025/5/21
 */
public class leetcode_718 {
  //dp[i][j]表示i-1,j-1结尾的最大重复子序列
  public static int findLength(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int[][] dp = new int[m + 1][n + 1];
    int result = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (nums1[i - 1] == nums2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          result = Math.max(dp[i][j], result);
        } else {
          dp[i][j] = 0;
        }
      }
    }
    return result;
  }
  public static int findLength01(int[] A, int[] B) {
    int m = A.length, n = B.length;
    int[] dp = new int[n + 1];  // 一维数组
    int maxLen = 0;

    for (int i = 1; i <= m; i++) {
      // 倒序遍历，避免 dp[j-1] 被提前覆盖
      for (int j = n; j >= 1; j--) {
        if (A[i - 1] == B[j - 1]) {
          dp[j] = dp[j - 1] + 1;
          maxLen = Math.max(maxLen, dp[j]);
        } else {
          dp[j] = 0;  // 不相等直接置为0
        }
      }

//      for (int j = 1; j <= n; j++) {
//        if (A[i - 1] == B[j - 1]) {
//          dp[j] = dp[j - 1] + 1;
//          maxLen = Math.max(maxLen, dp[j]);
//        } else {
//          dp[j] = 0;  // 不相等直接置为0
//        }
//      }
    }

    return maxLen;
  }
  public static void main(String[] args) {
    int[] nums1 = new int[]{1,1,3,2,1};
    int[] nums2 = new int[]{1,1,1,1,1};
    System.out.println(findLength01(nums1, nums2));
  }
}
