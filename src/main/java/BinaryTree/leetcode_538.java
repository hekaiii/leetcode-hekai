package BinaryTree;

import static BinaryTree.leetcode_102.levelOrder01;

import java.util.List;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/26
 */
public class leetcode_538 {

  private int count = 0;
  public  TreeNode convertBST(TreeNode root) {
    if (root == null) {
      return null;
    }
    convertBST(root.right);
    root.val = root.val + count;
    count = root.val;
    convertBST(root.left);
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.right = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.right = new TreeNode(3);
    root.left.left = new TreeNode(0);
    root.right.right = new TreeNode(7);
    root.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(8);
    leetcode_538 leetcode538 = new leetcode_538();
    TreeNode treeNode = leetcode538.convertBST(root);
    List<List<Integer>> list = levelOrder01(treeNode);
    System.out.println(String.valueOf(list));
  }
}
