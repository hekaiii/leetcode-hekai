package BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/4/23 20:33
 */
public class leetcode_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        postorder(arrayList,root);
        return arrayList;
    }

    public void postorder(ArrayList<Integer> arrayList,TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(arrayList,root.left);
        postorder(arrayList,root.right);
        arrayList.add(root.val);
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
