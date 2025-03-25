package BinaryTree;

import com.sun.org.apache.bcel.internal.generic.NEW;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * @Date: 2022/4/23 20:33
 */


public class leetcode_144 {

    /**
     * 前序遍历 主要是两种方式 迭代法和递归法
     */
    //递归法
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderRecursion(root,result);
        return result;
    }
    private static void preorderRecursion(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderRecursion(root.left, result);
        preorderRecursion(root.right, result);
    }

    //层序遍历
    public static List<Integer> preorderTraversal01(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode pop = nodes.pop();
            result.add(pop.val);
            if (pop.right != null) {
                nodes.push(pop.right);
            }
            if (pop.left != null) {
                nodes.push(pop.left);
            }
        }
        return result;
    }

    private static void preorderRecursion01(TreeNode root, List<Integer> result) {

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        List<Integer> list = preorderTraversal01(root);
        System.out.println(list.toString());
    }
}
