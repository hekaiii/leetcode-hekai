package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/13
 */
public class leetcode_213 {

  public static int rob(int[] nums) {
    if (nums.length <= 3) {
      int result = 0;
      for (int num : nums) {
        result = Math.max(result, num);

      }
      return result;
    }
    int a = robLinear(nums, 0, nums.length - 2);
    int b = robLinear(nums, 1, nums.length - 1);
    return Math.max(a, b);
  }

  public static int robLinear(int[] nums, int start, int end) {
    int prev_2 = 0, prev_1 = 0;
    for (int i = start; i <= end; i++) {
      int cur = Math.max(nums[i] + prev_2, prev_1);
      prev_2 = prev_1;
      prev_1 = cur;
    }
    return prev_1;
  }
  public static void main(String[] args) {
    int[] nums = new int[]{2, 3, 2};
    System.out.println(rob(nums));

  }
}
