package BinaryTree;


import java.util.LinkedList;

/**
 * @Date: 2022/4/26 11:23
 */
public class leetcode_226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        invert(root.left);
        invert(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public static TreeNode invertTree01(TreeNode root) {
        if (root == null) {
            return root;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode poll = nodes.poll();
            if (poll.left != null) {
                nodes.add(poll.left);
            }
            if (poll.right != null) {
                nodes.add(poll.right);
            }
            TreeNode tmpNode = poll.left;
            poll.left = poll.right;
            poll.right = tmpNode;
        }
        return root;
    }

//    public TreeNode invertTree02(TreeNode root) {
//
//    }

    public static TreeNode invertTree03(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) {
            invertTree03(root.left);
        }
        if (root.right != null) {
            invertTree03(root.right);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode treeNode = invertTree03(root);
        TreeNode.printTreeLevelOrder(treeNode);
    }
}

