package BackTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025/1/2
 */
public class leetcode_39 {
  static ArrayList result = new ArrayList<List<Integer>>();
  static ArrayList list = new ArrayList<Integer>();
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    if (candidates[0] > target) {
      return result;
    }
    getResult(candidates, target, 0,0);
    return result;
  }

  private static void getResult(int[] candidates, int target, int sum, int start) {
    if (sum == target) {
      result.add(new ArrayList<Integer>(list));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      if (sum + candidates[i] <= target) {
        list.add(candidates[i]);
        getResult(candidates, target, sum + candidates[i],i);
        list.remove(list.size() - 1);
      } else {
        break;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {8,7,4,3};
    List<List<Integer>> lists = combinationSum(a, 11);
    for (List<Integer> integers : lists) {
      System.out.println(integers.toString());
    }
  }
}
