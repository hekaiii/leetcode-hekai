package BinaryTree;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/11
 */
public class leetcode_222 {
  public static int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int depthLeft = getDepth(root.left);
    int depthRight = getDepth(root.right);
    if (depthRight == depthLeft) {
      //左子树满
      return countNodes(root.right) + (1<< depthLeft);
    } else {
      //右子树满
      return countNodes(root.left) + (1<< depthRight);
    }
  }

  private static int getDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int depth = 0;
    while (node != null) {
      depth++;
      node = node.left;
    }
    return depth;
  }

  public static int countNodes01(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1+countNodes01(root.left)+countNodes01(root.right);
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    System.out.println(countNodes(root));
  }
}
