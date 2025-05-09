package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/8
 */
public class leetcode_199 {
  public static List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    LinkedList<TreeNode> treeNodes = new LinkedList<>();
    treeNodes.add(root);
    while (!treeNodes.isEmpty()) {
      int size = treeNodes.size();
      for (int i = 0; i < size; i++) {
        TreeNode poll = treeNodes.poll();
        if (i == size - 1) {
          result.add(poll.val);
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

  public static List<Integer> rightSideView01(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      for (int i = size; i >= 1; i--) {
        TreeNode poll = nodes.poll();
        if (i == 1) {
          result.add(poll.val);
        }
        if (poll.left != null) {
          nodes.add(poll.left);
        }
        if (poll.right != null) {
          nodes.add(poll.right);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(4);
    List<Integer> integers = rightSideView01(root);
    for (Integer num : integers) {
      System.out.print(num + " ");
    }
    System.out.println();  // 换行
  }
}
