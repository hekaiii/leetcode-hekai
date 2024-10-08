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
    String string = Arrays.toString(sortedSquares03(nums));
    System.out.println(string);
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

  //todo 220240819
  public static int[] sortedSquares03(int[] nums) {
    int[] result = new int[nums.length];
    int l = 0;
    int r = nums.length - 1;
    for (int i = nums.length-1; i >= 0; i--) {
      if (nums[l] * nums[l] >= nums[r] * nums[r]) {
        result[i] = nums[l] * nums[l];
        l++;
      } else {
        result[i] = nums[r] * nums[r];
        r--;
      }
    }
    return result;
  }
}
