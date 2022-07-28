package BinaryTree;

/**
 * @Date: 2022/4/26 14:19
 */
public class leetcode_104_01 {

    public static int maxdepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftdepth = maxdepth(root.left);
        int rightdepth = maxdepth(root.right);
        return Math.max(leftdepth, rightdepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        int maxdepth = maxdepth(root);
        System.out.println(maxdepth);
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
