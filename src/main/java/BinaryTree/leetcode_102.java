package BinaryTree;

import sun.reflect.generics.tree.Tree;
import test.BinarySearchTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * @Date: 2022/4/23 21:38
 */
public class leetcode_102 {
    private TreeNode root;
    public static List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        level(root,0);
        return resList;
    }

    public static void level(TreeNode node, Integer deep) {
        if (node == null) return;

        deep++;
        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        level(node.left, deep);
        level(node.right, deep);
    }

    public static void main(String[] args) {
        leetcode_102 tree = new leetcode_102();
        int input[]= {1,2,3,4,5,6,7};
        for(int i=0; i<input.length; i++) {
            tree.insert(input[i]);
        }
        List<List<Integer>> lists = levelOrder(tree.root);
        System.out.println(lists);
    }

    //插入二叉平衡树结点
    public boolean insertAVL(int data) {
        TreeNode node = new TreeNode(data);
        if(root == null){
            root = node;
            return true;
        }
        TreeNode targetNode  = root;
        while (targetNode != null) {
            if( data == targetNode.val){
                System.out.println("二叉查找树中已有重复的结点：" + data);
                return false;
            }
            else if (data > targetNode.val) {
                if(targetNode.right == null){
                    targetNode.right = node;
                    return true;
                }
                targetNode = targetNode.right;
            }
            else {
                if(targetNode.left == null){
                    targetNode.left = node;
                    return true;
                }
                targetNode = targetNode.left;
            }
        }
        return true;
    }

    //插入二叉树
    public void insert(int data) {

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
