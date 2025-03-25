package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Date: 2022/4/23 20:33
 */
public class leetcode_145 {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderRecursion(root, result);
        return result;
    }

    private static void postorderRecursion(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderRecursion(root.left, result);
        postorderRecursion(root.right, result);
        result.add(root.val);
    }

    public static List<Integer> postorderTraversal01(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
         Collections.reverse(result);
        return result;
    }
    public static void main(String[] args) {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(2);
        root.right = new BinaryTree.TreeNode(1);
        root.right.left = new TreeNode(3);
        List<Integer> list = postorderTraversal01(root);
        System.out.println(list.toString());
    }
}
