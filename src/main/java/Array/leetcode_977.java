package Array;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/2 17:09
 */
public class leetcode_977 {

  public static void main(String[] args) {
    int[] nums = new int[]{-4, -1, 0, 3, 10};
    System.out.println(sortedSquares02(nums));
  }

  public static int[] sortedSquares01(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums[i] * nums[i];
    }
    Arrays.sort(nums);
    return nums;
  }

  public static int[] sortedSquares02(int[] nums) {
    int[] result = new int[nums.length];
    int i = 0;
    int j = nums.length - 1;
    int index = nums.length - 1;
    while (i <= j) {
      if (nums[j] * nums[j] >= nums[i] * nums[i]) {
        result[index--] = nums[j] * nums[j];
        j--;
      } else {
        result[index--] = nums[i] * nums[i];
          i++;
      }
    }
      return result;
  }
}
