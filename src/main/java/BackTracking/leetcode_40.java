package BackTracking;

import static BackTracking.leetcode_216.list;
import static BackTracking.leetcode_216.result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.sound.midi.Soundbank;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025/1/2
 */
public class leetcode_40 {
  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    ArrayList<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    if (candidates[0] > target) {
      return result;
    }
    backtracking(candidates, target, 0, 0,result,list);
    return result;
  }

  private static void backtracking(int[] candidates, int target, int sum, int start,
      ArrayList<List<Integer>> result, ArrayList<Integer> list) {
    if (sum == target) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      if (i > start && candidates[i] == candidates[i - 1]) {
        continue;
      }
      if (sum + candidates[i] <= target) {
        list.add(candidates[i]);
        backtracking(candidates, target, sum + candidates[i], i + 1,result,list);
        list.remove(list.size() - 1);
      } else {
        break;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {10, 1, 2, 7, 6, 1, 5};
    List<List<Integer>> lists = combinationSum2(a, 8);
    for (List<Integer> integers : lists) {
      System.out.println(integers.toString());
    }
  }
}
