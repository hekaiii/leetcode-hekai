package BinaryTree;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/15
 */
public class leetcode_105 {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) {
      return null;
    }
    return getSubTreeNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode getSubTreeNode(int[] preorder, int preStart, int preEnd, int[] inorder,
      int inStart, int inEnd) {
    if (inEnd < inStart || preEnd < preStart) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int index = 0;
    for (; index < inEnd; index++) {
      if (inorder[index] == root.val) {
        break;
      }
    }
    int leftSize = index - inStart;
    root.left = getSubTreeNode(preorder, preStart + 1, preStart + leftSize, inorder, inStart,
        inStart + leftSize);
    root.right = getSubTreeNode(preorder, preStart + 1 + leftSize, preEnd, inorder, index + 1,
        inEnd);

    return root;
  }

  public static void main(String[] args) {

  }
}
