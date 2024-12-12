package BinaryTree;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/12
 */
public class leetcode_110 {

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    Integer depthLeft = getDepth(root.left);
    Integer depthRight = getDepth(root.right);
    int result = depthRight - depthLeft;
    if (result < -1 || result > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

  private Integer getDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return Math.max(getDepth(node.right), getDepth(node.left)) + 1;
  }

  public static void main(String[] args) {

  }
}
