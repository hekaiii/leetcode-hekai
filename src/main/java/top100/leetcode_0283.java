package top100;

/**
 * @Author: hek32
 * @Description:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * @Date: 2025/7/2
 */
public class leetcode_0283 {
  public static void moveZeroes(int[] nums) {
    if (nums.length != 1) {
      int slow = 0;
      for (int fast = 1; fast < nums.length; fast++) {
        if (nums[slow] == 0 && nums[fast] != 0) {
          nums[slow] = nums[fast];
          nums[fast] = 0;
          slow++;
        } else if (nums[slow] != 0) {
          slow++;
        }
      }
    }
  }

  public static void moveZeroes01(int[] nums) {
    int index = 0;
    for (int num : nums) {
      if (num != 0) {
        nums[index++] = num;
      }
    }
    while (index < nums.length) {
      nums[index++] = 0;
    }
  }

  public static void main(String[] args) {
    moveZeroes(new int[]{1, 0, 1});
  }
}
