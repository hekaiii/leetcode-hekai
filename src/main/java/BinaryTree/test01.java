package BinaryTree;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/4/26 10:17
 */
public class test01 {
    public List<List<Integer>> arrayList = new ArrayList<List<Integer>>();

    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.println(treeNode.val);
        inOrder(treeNode.right);
    }

    public void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.val);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        level(root, 0);
        return arrayList;
    }

    public void level(TreeNode root, int deep) {
        if (root == null) {
            return;
        }

        deep++;
        if (arrayList.size() < deep) {
            ArrayList<Integer> add = new ArrayList<>();
            arrayList.add(add);
        }
        arrayList.get(deep - 1).add(root.val);
        level(root.left, deep);
        level(root.right, deep);
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
