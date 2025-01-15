package BinaryTree;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/11/20
 */
public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
