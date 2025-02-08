package Greedy;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-02-08 21:22:19
 */
public class leetcode_55 {
  public static boolean canJump(int[] nums) {
    if (nums.length == 1 ) {
      return true;
    }
    int range = 0;
    for (int i = 0; i <= range; i++) {
      range = Math.max(range, i + nums[i]);
      if (range >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    int[] a = {2,3,1,1,4};
    System.out.println(canJump(a));
  }
}
