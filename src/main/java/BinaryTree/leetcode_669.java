package BinaryTree;

import static BinaryTree.leetcode_102.levelOrder01;

import java.util.List;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/25
 */
public class leetcode_669 {
  public static TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null) {
      return null;
    }
    if (root.val <= high && root.val >= low) {
      root.right = trimBST(root.right, low, high);
      root.left = trimBST(root.left, low, high);
    } else if (root.val < low) {
      root = trimBST(root.right, low, high);
    } else if (root.val > high) {
      root = trimBST(root.left, low, high);
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(0);
    root.right = new TreeNode(4);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(1);
    TreeNode treeNode = trimBST(root, 1, 3);
    List<List<Integer>> list = levelOrder01(treeNode);
    System.out.println(String.valueOf(list));
  }
}
