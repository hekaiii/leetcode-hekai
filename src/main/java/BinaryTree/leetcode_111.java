package BinaryTree;

import java.util.LinkedList;

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

    public int minDepth01(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            result++;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = nodes.poll();
                if (poll.left != null) {
                    nodes.add(poll.left);
                }
                if (poll.right != null) {
                    nodes.add(poll.right);
                }
                if (poll.left == null && poll.right == null) {
                    return result;
                }
            }
        }
        return result;
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
