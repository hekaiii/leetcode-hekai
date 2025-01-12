package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/1/10
 */
public class leetcode_46 {
  public static List<List<Integer>> permute(int[] nums) {
    ArrayList<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    if (nums.length == 1) {
      list.add(nums[0]);
      result.add(new ArrayList<>(list));
      return result;
    }
    int[] used = new int[nums.length];
    backtracking(nums,list,result,used);
    return result;
  }

  private static void backtracking(int[] nums, ArrayList<Integer> list,
      ArrayList<List<Integer>> result, int[] used) {
    if (list.size() == nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i] != 1) {
        used[i] = 1;
        list.add(nums[i]);
        backtracking(nums, list, result,used);
        list.remove(list.size() - 1);
        used[i] = 0;
      }
    }
  }


  public static void main(String[] args) {
    List<List<Integer>> permute = permute(new int[]{1,1,2});
    for (List<Integer> integers : permute) {
      System.out.println(integers.toString());
    }
  }
}
