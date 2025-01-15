package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/11/7
 */
public class leetcode18 {
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> lists = new ArrayList<>();
    if (nums == null || nums.length < 4) {
      return lists;
    }
    for (int a = 0; a < nums.length - 3; a++) {
      if (a > 0 && nums[a] == nums[a - 1]) {
        continue;
      }
      for (int b = nums.length - 1; b >= 3; b--) {
        if (b < nums.length - 1 && nums[b] == nums[b + 1]) {
          continue;
        }
        int c = a + 1;
        int d = b - 1;
        while (c < d) {
          long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
          if (sum == target) {
            lists.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
            while (c < d && nums[c] == nums[c + 1]) {
              c++;
            }
            while (c < d && nums[d] == nums[c - 1]) {
              d--;
            }
            d--;
            c++;
          }
          if (sum > target) {
            d--;
          } else if (sum < target) {
            c++;
          }
        }
      }
    }
    return lists;
  }
  public static void main(String[] args) {
    int[] a = {1000000000,1000000000,1000000000,1000000000};
    fourSum(a, -294967296);
  }
}
