package BinaryTree;

/**
 * @Date: 2022/4/26 13:01
 */
public class leetcode_104 {
    public int depth = 0;
    public int maxDepth(TreeNode root) {
        int deep = 0;
        level(root, deep);
        return depth;
    }
    public void level(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        deep++;
        if (deep > depth) {
            depth++;
        }
        level(root.left, deep);
        level(root.right, deep);
    }
    public static int maxDepth01(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth01(root.left), maxDepth01(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(maxDepth01(root));
    }
}
