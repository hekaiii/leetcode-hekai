package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/30
 */
public class leetcode_216 {

  static ArrayList<Integer> list = new ArrayList<>();
  static List<List<Integer>> result = new ArrayList<>();
  static int count = 0;
  public static  List<List<Integer>> combinationSum3(int k, int n) {
    backtracking01(k, n, 1,0);
    return result;
  }

  //未剪枝
  private static void backtracking(int k, int target, int start) {
    if (list.size() == k) {
      int count = 0;
      for (Integer i : list) {
        count += i;
      }
      if (count == target) {
        result.add(new ArrayList<>(list));
      }
      return;
    }
    for (int i = start; i < 10; i++) {
      list.add(i);
      count = result.size();
      backtracking(k, target, i + 1);
      list.remove(list.size() - 1);
      if (result.size() - count == 1) {
        break;
      }
    }
  }
  //剪枝
  private static void backtracking01(int k, int target, int start,int sum) {
    if (list.size() == k) {
      if (sum == target) {
        result.add(new ArrayList<>(list));
      }
      return;
    }

    for (int i = start; i <= (9-(k-list.size())+1); i++) {
      if (sum > target) {
        break;
      }
      list.add(i);
      backtracking01(k, target, i + 1, sum + i);
      list.remove(list.size() - 1);
    }
  }


  public static void main(String[] args) {
    List<List<Integer>> lists = combinationSum3(3, 9);
    for (List<Integer> integers : lists) {
      System.out.println(integers.toString());
    }
  }
}
