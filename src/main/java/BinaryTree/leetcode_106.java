package BinaryTree;

import java.util.Arrays;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/14
 */
public class leetcode_106 {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (postorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[postorder.length - 1]);

    int inorderIndex = 0;
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == root.val) {
        inorderIndex = i;
      }
    }
    int[] leftTree =new int[inorderIndex];
    for (int i = 0; i < inorderIndex; i++) {
      leftTree[i] = inorder[i];
    }

    for (int i = inorderIndex; i < postorder.length - 1; i++) {


    }

    int[] rightTree = new int[];

    buildTree();
  }
  public static void main(String[] args) {

  }
}
