package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/4/26 12:32
 * 递归和其他便利方法
 */
public class leetcode_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return compare(root.right, root.left);
    }

    public static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (right == null && left != null) {
            return false;
        }
        if (right == null && left == null) {
            return true;
        }
        if (right.val != left.val) {
            return false;
        }
        boolean compare = compare(left.left, right.right);
        boolean compare1 = compare(left.right, right.left);
        return compare&&compare1;
    }

    public boolean isSymmetric01(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right,
            right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric02(root));
    }
}
