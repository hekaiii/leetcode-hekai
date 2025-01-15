package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/11/7
 */
public class leetcode15 {
  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    if (nums[nums.length - 1] < 0 || nums[0] > 0) {
      return result;
    }

    for (int i = 0; i <= nums.length - 3; i++) {
      if (nums[i] > 0) {
        break;
      }
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < 0) {
          j++;
        } else if (sum > 0) {
          k--;
        } else if (sum == 0) {
          List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
          result.add(list);
          while (j < k && nums[k] == nums[k - 1]) {
            k--;
          }
          while (j < k && nums[j] == nums[j+1]) {
            j++;
          }
          k--;
          j++;
        }
      }
    }
    return result;
  }
  public static void main(String[] args) {

  }
}
