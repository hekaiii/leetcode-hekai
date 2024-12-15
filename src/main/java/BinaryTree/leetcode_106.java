package BinaryTree;

import com.sun.org.apache.bcel.internal.generic.POP;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/14
 */
public class leetcode_106 {
  public static TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0) {
      return null;
    }
    return getSubTreeNode(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  private static TreeNode getSubTreeNode(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
      int postEnd) {
    if (inEnd < inStart || postEnd < postStart) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[postEnd]);
    int index = 0;
    for (; index < inEnd; index++) {
      if (inorder[index] == root.val) {
        break;
      }
    }
    int leftSize = index - inStart;
    root.left = getSubTreeNode(inorder, inStart, index - 1, postorder, postStart,
        postStart + leftSize - 1);
    root.right = getSubTreeNode(inorder, index + 1, inEnd, postorder, postStart + leftSize,
        postEnd - 1);
    return root;
  }


  public static void main(String[] args) {
    int[] inorder = {9, 3, 15, 20, 7};
    int[] postorder = {9, 15, 7, 20, 3};

    TreeNode treeNode = buildTree(inorder, postorder);
  }
}
