package DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: hekai
 * @Description:
 * 1.dp数组的含义
 * 2.dp推导公式
 * 3.数组初始化
 * 4.遍历方向
 * @Date: 2025-04-14 21:22:34
 */
public class leetcode_416 {

  public static boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 == 1) {
      return false;
    }
    int target = Arrays.stream(nums).sum() / 2;
    //1.前i个物品的最大值
    int[] dp = new int[target + 1];
    //2.dp推导公式 & 3.dp初始化
    for (int num : nums) {
      for (int j = target; j >= num; j--) {
        dp[j] = Math.max(dp[j], dp[j - num] + num);
        if (dp[target] == target) {
          return true;
        }
      }
    }
    return false;
  }

  // 比较抽象
  //boolean[] dp
  // dp[i]的含义是这个数组的子集能不能构成i 能为true 所以返回dp[sum/2]
  public static boolean canPartitionGPT(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    int target = sum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int num : nums) {
      for (int j = target; j >= num; j--) {
        dp[j] = dp[j] || dp[j - num];
      }
    }

    return dp[target];
  }

  public static void main(String[] args) {
    System.out.println(canPartitionGPT(new int[]{1, 5, 11, 5}));
  }
}
