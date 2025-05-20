package DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/19
 */
public class leetcode_300 {

  /**
   * 输出最大递增子串的长度 dp[i]的值就代表当前前i个元素的最大递增子串的长度
   * [10,9,2,6,3,5,101,18]
   * [1,1,1,2,2,3,4]
   * [1,1,1,2,2,3,4,4]
   * 4
   *
   * 4, 10, 4, 3, 8, 9
   * 1,2,2,2,3,4,
   *
   * if num[i]>num[i-1] dp[i]=dp[i-1]+1
   * @param nums
   * @return
   */
  public static int lengthOfLIS(int[] nums) {
    int result = Integer.MIN_VALUE;
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[j]+1,dp[i]);
          result = Math.max(dp[i], result);
        }
      }
    }
    return result;
  }

  public static int lengthOfLIS01(int[] nums){
    int[] tails = new int[nums.length];
    int size = 0;
    for (int num : nums) {
      int left = 0, right = size;
      // 找到第一个 >= num 的位置
      while (left < right) {
        int mid = (left + right) / 2;
        if (tails[mid] < num) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      // 替换或扩展
      tails[left] = num;
      if (left == size) size++;
    }

    return size;
  }


  public static void main(String[] args) {
    int[] dp = new int[]{10,9,2,5,1,7,101,18};
    System.out.println(lengthOfLIS01(dp));
  }
}
