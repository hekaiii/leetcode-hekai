package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/8
 */
public class leetcode_107 {

  public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayDeque<TreeNode> lists = new ArrayDeque<>();
    lists.add(root);
    while (!lists.isEmpty()) {
      ArrayList<Integer> list = new ArrayList<>();
      int size = lists.size();
      for (int i = 0; i < size; i++) {
        TreeNode poll = lists.poll();
        list.add(poll.val);
        if (poll.left != null) {
          lists.add(poll.left);
        }
        if (poll.right != null) {
          lists.add(poll.right);
        }
      }
      result.add(list);
    }
    Collections.reverse(result);
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    List<List<Integer>> list = levelOrderBottom(root);
    System.out.println(String.valueOf(list));
  }
}
