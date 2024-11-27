package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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

    public static List<Integer> preorderTraversal01(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preorder01(root, list);
        return list;
    }

    public static void preorder01(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }
        array.add(root.val);
        preorder01(root.left, array);
        preorder01(root.right, array);
    }

    public static List<Integer> preorderTraversal02(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preorder02(root, result);
        return result;
    }

    /**
     前中后
     前：中左右
     中：左中右
     后：左右中
     *
     */
    public static void preorder02(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder02(root.left, result);
        preorder02(root.right, result);
    }
    public static void preorder03(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        preorder02(root.left, result);
        result.add(root.val);
        preorder02(root.right, result);
    }
    public static void preorder04(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        preorder02(root.left, result);
        preorder02(root.right, result);
        result.add(root.val);
    }

    //非递归 前序遍历
    public static List<Integer> preorderTraversal03(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return list;
    }

    /**
     *    非递归 后续遍历 前序是ABC 后序就是BCA=ABC->ACB->BCA
     *    现在前序的基础上改变 BC的顺序，再将结果反转
     */

    public static List<Integer> preorderTraversal04(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);

            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        List<Integer> list = preorderTraversal01(root);
        System.out.println(String.valueOf(list));
    }
}
