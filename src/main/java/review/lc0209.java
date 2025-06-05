package review;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/6/5
 */
public class lc0209 {

  public static int minSubArrayLen(int target, int[] nums) {
    int result = Integer.MAX_VALUE;
    int start = 0;
    int sum = 0;
    for (int end = 0; end < nums.length; end++) {
      sum += nums[end];
      while (sum >= target) {
        result = Math.min(end - start + 1, result);
        if (result == 1) {
          return 1;
        }
        sum -= nums[start];
        start++;
      }
    }
    return result != Integer.MAX_VALUE ? result : 0;
  }

  public static void main(String[] args) {
    System.out.println(minSubArrayLen(7, new int[]{3, 1, 1, 1, 3, 4}));
  }
}
