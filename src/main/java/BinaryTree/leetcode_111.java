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
    public static int minDepth02(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth02(root.left);
        int right = minDepth02(root.right);
        if (left == 0 && right != 0) {
            return right + 1;
        }
        if (left != 0 && right == 0) {
            return left + 1;
        }
        if (left != 0 && right != 0) {
            return Math.max(left, right) + 1;
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(4);
        System.out.println(minDepth02(root));
    }
}
