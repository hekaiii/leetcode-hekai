package BinaryTree;

import static BinaryTree.leetcode_102.level;
import static BinaryTree.leetcode_102.levelOrder01;

import com.sun.org.apache.bcel.internal.generic.RET;
import java.util.Date;
import java.util.List;
import javax.print.DocFlavor.READER;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/24
 */
public class leetcode_450 {
  //右节点上位
  public static TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (key == root.val) {
      if (root.left != null && root.right != null) {
        TreeNode fast = root.right;
        while (fast.left != null) {
          fast = fast.left;
        }
        fast.left = root.left;
        root = root.right;
        return root;
      } else if (root.left == null && root.right == null) {
        return null;
      } else {
        return root.left != null ? root.left : root.right;
      }
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {
      root.left = deleteNode(root.left, key);
    }
    return root;
  }

  //左节点上位
  public static TreeNode deleteNode01(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (key == root.val) {
      if (root.left != null && root.right != null) {
        TreeNode fast = root.left;
        while (fast.right != null) {
          fast = fast.right;
        }
        fast.right = root.right;
        root = root.left;
        return root;
      } else if (root.left == null && root.right == null) {
        return null;
      } else {
        return root.left != null ? root.left : root.right;
      }
    } else if (key > root.val) {
      root.right = deleteNode01(root.right, key);
    } else {
      root.left = deleteNode01(root.left, key);
    }
    return root;
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.right.right = new TreeNode(7);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    TreeNode treeNode = deleteNode(root, 3);
    List<List<Integer>> list = levelOrder01(treeNode);
    System.out.println(String.valueOf(list));
  }
}
