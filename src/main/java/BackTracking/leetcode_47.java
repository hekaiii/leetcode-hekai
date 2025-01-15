package BackTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025/1/13
 */
public class leetcode_47 {
  static ArrayList<Integer> list = new ArrayList<>();
  static ArrayList<List<Integer>> result = new ArrayList<>();
  public static List<List<Integer>> permuteUnique(int[] nums) {

    if (nums.length == 1) {
      list.add(nums[0]);
      result.add(list);
      return result;
    }
    Arrays.sort(nums);
    int[] used = new int[nums.length];
    backTracking(nums, used);
    return result;
  }

  private static void backTracking(int[] nums, int[] used) {
    if (list.size() == nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
        continue;
      }
      if (used[i] == 0) {
        list.add(nums[i]);
        used[i] = 1;
        backTracking(nums, used);
        used[i] = 0;
        list.remove(list.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
    for (List<Integer> integers : lists) {
      System.out.println(integers.toString());
    }
  }
}
