package BinaryTree;

import javax.swing.tree.TreeNode;

/**
 * @Date: 2022/4/26 14:38
 */
public class leetcode_111 {
    public int minDepth(TreeNode root) {
        int deep = 0;
        if (root.left == null && root.right != null) {
            deep = min(root.right);
        } else if (root.left != null && root.right == null) {
            deep = min(root.left);
        } else {
            min(root);
        }
        return deep;
    }

    public int min(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        } else if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
