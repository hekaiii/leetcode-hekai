package BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/4/23 20:33
 */
public class leetcode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        inoreder(arrayList,root);
        return arrayList;
    }

    public void inoreder(ArrayList<Integer> arrayList,TreeNode root) {
        if (root == null) {
            return;
        }
        inoreder(arrayList,root.left);
        arrayList.add(root.val);
        inoreder(arrayList,root.right);
    }

    private class TreeNode{
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
