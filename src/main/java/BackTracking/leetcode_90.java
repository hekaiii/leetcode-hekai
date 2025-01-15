package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025/1/8
 */
public class leetcode_90 {
  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    ArrayList<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    backTracking(nums, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private static void backTracking(int[] nums, int start, ArrayList<Integer> list,
      ArrayList<List<Integer>> result) {
    result.add(new ArrayList<>(list));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }
      list.add(nums[i]);
      backTracking(nums, i + 1, list, result);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> lists = subsetsWithDup(new int[]{1, 2, 2});
    for (List<Integer> list : lists) {
      System.out.println(list.toString());
    }
  }
}
