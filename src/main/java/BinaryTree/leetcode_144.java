package BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2022/4/23 20:33
 *
 */



public class leetcode_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        preorder(root,arrayList);
        return arrayList;
    }

    public void preorder(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }
        array.add(root.val);
        preorder(root.left,array);
        preorder(root.right,array);
    }

    static private class TreeNode{
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
