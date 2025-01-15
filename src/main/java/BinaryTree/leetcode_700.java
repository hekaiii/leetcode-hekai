package BinaryTree;

import java.util.LinkedList;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/17
 */
public class leetcode_700 {
  //递归
  public static TreeNode searchBST01(TreeNode root, int val) {
    TreeNode result = null;
    if (root == null) {
      return result;
    } else if (root.val == val) {
      return root;
    } else if (root.val > val) {
      result = searchBST01(root.left, val);
    } else {
      result = searchBST01(root.right, val);
    }
    return result;
  }
  //层序遍历
  public static TreeNode searchBST02(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    LinkedList<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        TreeNode poll = nodes.poll();
        if (poll.val == val) {
          return poll;
        }
        if (poll.left != null) {
          nodes.add(poll.left);
        }
        if (poll.right != null) {
          nodes.add(poll.right);
        }
      }
    }
    return null;
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.right = new TreeNode(3);
    root.left.left = new TreeNode(1);
    searchBST01(root, 2);
  }
}
