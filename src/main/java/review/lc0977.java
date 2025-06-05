package review;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/6/5
 */
public class lc0977 {
  public static int[] sortedSquares(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    int index = nums.length - 1;
    while (l <= r) {
      if (nums[r] * nums[r] >= nums[l] * nums[l]) {
        nums[index] = nums[r] * nums[r];
        index--;
        r--;
      } else {
        nums[index] = nums[l] * nums[l];
        l++;
      }
    }
    return nums;
  }

  public static void main(String[] args) {

  }
}
