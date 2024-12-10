package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/9
 */
public class leetcode_515 {

  public static List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    LinkedList<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode poll = nodes.poll();
        max = poll.val > max ? poll.val : max;
        if (poll.left != null) {
          nodes.add(poll.left);
        }
        if (poll.right != null) {
          nodes.add(poll.right);
        }
      }
      result.add(max);
    }
    return result;
  }

  public static void main(String[] args) {

  }
}
