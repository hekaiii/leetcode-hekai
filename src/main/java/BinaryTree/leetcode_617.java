package BinaryTree;

import java.util.LinkedList;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/16
 */
public class leetcode_617 {
  public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return null;
    } else if (root1 != null && root2 == null) {
      return root1;
    } else if (root1 == null && root2 != null) {
      return root2;
    }
    TreeNode node = new TreeNode(root1.val + root2.val);
    node.left = mergeTrees(root1.left, root2.left);
    node.right = mergeTrees(root1.right, root2.right);
    return node;
  }
  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.left.left = new TreeNode(3);
    TreeNode root2 = new TreeNode(1);
    root2.right = new TreeNode(2);
    root2.right.right = new TreeNode(3);
    mergeTrees(root1, root2);
  }
}
