package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025/1/9
 */
public class leetcode_491 {

  public static List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length == 1) {
      return result;
    }
    ArrayList<Integer> list = new ArrayList<>();
    backTracking(nums, 0, list, result);
    return result;
  }

  private static void backTracking(int[] nums, int start, ArrayList<Integer> list,
      List<List<Integer>> result) {
    if (list.size() > 1) {
      result.add(new ArrayList<>(list));
    }
    Set<Integer> used = new HashSet<>();
    for (int i = start; i < nums.length; i++) {
      if (used.contains(nums[i])) {
        continue;
      }
      if (list.size() == 0 || (list.size() > 0 && nums[i] >= list.get(list.size() - 1))) {
        list.add(nums[i]);
        used.add(nums[i]);
        backTracking(nums, i + 1, list, result);
        list.remove(list.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> subsequences = findSubsequences(new int[]{1,2,3,1,1,1,1,1});
    for (List<Integer> subsequence : subsequences) {
      System.out.println(subsequence.toString());

    }
  }
}
