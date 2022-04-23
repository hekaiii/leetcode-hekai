package BinaryTree;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl;
import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2022/4/23 22:38
 */
public class leetcode_102_1 {
    public List<List<Integer>> resArr = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        level(root, 0);
        return resArr;
    }

    public void level(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        deep++;
        if (deep > resArr.size()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            resArr.add(arrayList);
        }
        resArr.get(deep - 1).add(root.val);
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
