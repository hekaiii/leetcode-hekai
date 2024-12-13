package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/13
 */
public class leetcode_112 {
  public static boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    return getResult(root,targetSum);
  }

  private static boolean getResult(TreeNode node,int target) {
    target -= node.val;
    if (node.left == null && node.right == null && target == 0) {
      return true;
    }
    if (node.left != null) {
      if (getResult(node.left, target)) {
        return true;
      }
    }
    if (node.right != null) {
      if (getResult(node.right, target)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(hasPathSum(root,3));

  }
}
