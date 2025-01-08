package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/1/8
 */
public class leetcode_78 {
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    backTracking(nums, new ArrayList<>(), result, 0);
    return result;
  }

  private static void backTracking(int[] nums, List<Integer> list, List<List<Integer>> result, int start) {
    if (result.size() == 2 << nums.length) {
      return;
    }
    for (int i = start; i < nums.length; i++) {
      list.add(nums[i]);
      result.add(new ArrayList<>(list));
      backTracking(nums, list, result, i + 1);
      list.remove(list.size() - 1);
    }

  }


  public static void main(String[] args) {
    List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
    for (List<Integer> subset : subsets) {
      System.out.println(subset.toString());

    }
  }
}
