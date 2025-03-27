package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/9
 */
public class leetcode_637 {

  public static List<Double> averageOfLevels(TreeNode root) {
    ArrayList<Double> result = new ArrayList<>();
    LinkedList<TreeNode> treeNodes = new LinkedList<>();
    treeNodes.add(root);
    while (!treeNodes.isEmpty()) {
      int size = treeNodes.size();
      double count = 0;
      for (int i = 0; i < size; i++) {
        TreeNode poll = treeNodes.poll();
        count += poll.val;
        if (i == size - 1) {
          result.add((double) (count / size));
        }
        if (poll.left != null) {
          treeNodes.add(poll.left);
        }
        if (poll.right != null) {
          treeNodes.add(poll.right);
        }
      }
    }
    return result;
  }
  public static List<Double> averageOfLevels01(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      int num = size;
      Double count = new Double(0);
      while (size > 0) {
        TreeNode pop = nodes.pop();
        count += pop.val;
        size--;
        if (pop.left != null) {
          nodes.add(pop.left);
        }
        if (pop.right != null) {
          nodes.add(pop.right);
        }
        if (size == 0) {
          result.add(count / num);
        }
      }
    }
    return result;
  }
  public static void main(String[] args) {

  }
}
