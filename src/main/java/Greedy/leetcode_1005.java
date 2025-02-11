package Greedy;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-02-11 20:33:03
 */
public class leetcode_1005 {
  //很差的解法
  public int largestSumAfterKNegations(int[] nums, int k) {
    Arrays.sort(nums);
    for (int i = 0; i < k; i++) {
      nums[0] = -1 * nums[0];
      Arrays.sort(nums);
    }
    int result = 0;
    for (int num : nums) {
      result += num;
    }
    return result;
  }

  /**
   * 高效解法 将数组按照绝对值从大到小排列 然后遇到负数就*-1 消耗一个k 如果负数消耗完 k还多的话 判断k的奇偶性 偶数不变 奇数取最小值*-1
   */
  public static int largestSumAfterKNegations01(int[] nums, int k) {
    Integer[] sortedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(sortedNums,(a,b)->Math.abs(b)-Math.abs(a));
    for (int i = 0; i < nums.length; i++) {
      if (sortedNums[i] < 0 && k > 0) {
        sortedNums[i] = -1 * sortedNums[i];
        k--;
      }
    }
    //偶数
    if (k % 2 == 1) {
      sortedNums[sortedNums.length - 1] = -1 * sortedNums[sortedNums.length - 1];
    }
    return Arrays.stream(sortedNums).mapToInt(Integer::intValue).sum();
  }
  public static void main(String[] args) {
    System.out.println(largestSumAfterKNegations01(new int[]{3, -1, 0, 2}, 3));
  }
}
