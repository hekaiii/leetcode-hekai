package Greedy;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-02-08 22:37:19
 */
public class leetcode_45 {
  public static int jump(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    int result = 0;
    int maxRange = 0;
    int curRange = 0;
    for (int i = 0; i < nums.length; i++) {
      maxRange = Math.max(maxRange, nums[i] + i);
      if (maxRange >= nums.length - 1) {
        result++;
        break;
      }
      if (i == curRange && curRange != nums.length - 1) {
        curRange = maxRange;
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 1, 1, 4};
    System.out.println(jump(a));
  }
}
