package BinaryTree;

import BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/4/23 20:33
 */
public class leetcode_94 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inoreder(result,root);
        return result;
    }

    public static void inoreder(ArrayList<Integer> arrayList,TreeNode root) {
        if (root == null) {
            return;
        }
        inoreder(arrayList,root.left);
        arrayList.add(root.val);
        inoreder(arrayList,root.right);
    }

    public static void main(String[] args) {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(2);
        root.right = new BinaryTree.TreeNode(1);
        root.right.left = new BinaryTree.TreeNode(3);
        List<Integer> list = inorderTraversal(root);
        System.out.println(list.toString());
    }
}
