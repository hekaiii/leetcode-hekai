package BinaryTree;

/**
 * @Date: 2022/4/26 12:32
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
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
