package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.print.DocFlavor.READER;

/**
 * @Author: hekai
 * @Description:
 * void backtracking(参数) {
 *     if (终止条件) {
 *         存放结果;
 *         return;
 *     }
 *
 *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
 *         处理节点;
 *         backtracking(路径，选择列表); // 递归
 *         回溯，撤销处理结果
 *     }
 * }
 * @Date: 2024/12/29
 */
public class leetcode_77 {

  static private ArrayList<Integer> list = new ArrayList<>();
  static private ArrayList<List<Integer>> result = new ArrayList<>();
  public static List<List<Integer>> combine(int n, int k) {
    getResult(n, k, 1);
    return result;
  }

  private static void getResult(int n, int k,int start) {
    if (list.size() == k) {
      //显式深拷贝
      result.add(new ArrayList<>(list));
      return;
    }
    //当前节点下的每一个孩子
    for (int i = start; i <= (n - (k - list.size()) + 1); i++) {
      list.add(i);
      getResult(n, k, i + 1);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> combine = combine(4, 2);
    for (List<Integer> integers : combine) {
      System.out.println(integers.toString());
    }
  }
}
