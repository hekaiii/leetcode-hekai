package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author: hek32
 * @Description: 递归 迭代 层序 前 中左右 中 左中右 后 左右中
 * @Date: 2024/12/10
 */
public class review {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    preorderTraversal(root);
  }
  //递归
  public static List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    return preorder(root,result);
  }
  //递归三要素 1.入参 出参
  public static List<Integer> preorder(TreeNode node, List<Integer> result) {
    //2.递归终止条件
    if (node == null) {
      return result;
    }
    //3.递归体
    result.add(node.val);
    preorder(node.left, result);
    preorder(node.right, result);
    return result;
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    return inorder(root,result);
  }
  public static List<Integer> inorder(TreeNode node, List<Integer> result) {
    if (node == null) {
      return result;
    }
    preorder(node.left, result);
    result.add(node.val);
    preorder(node.right, result);
    return result;
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    return postorder(root,result);
  }
  public static List<Integer> postorder(TreeNode node, List<Integer> result) {
    if (node == null) {
      return result;
    }
    preorder(node.left, result);
    preorder(node.right, result);
    result.add(node.val);
    return result;
  }

  //迭代
  public List<Integer> preorderTraversal01(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode pop = stack.pop();
      result.add(pop.val);
      if (pop.right != null) {
        stack.push(pop.right);
      }
      if (pop.left != null) {
        stack.push(pop.left);
      }
    }
    return result;
  }
  public List<Integer> inorderTraversal01(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    TreeNode cursor = root;
    Stack<TreeNode> stack = new Stack<>();
    while (!stack.isEmpty() || cursor != null) {
      while (cursor != null) {
        stack.push(cursor);
        cursor = cursor.left;
      }
      cursor = stack.pop();
      result.add(cursor.val);
      cursor = cursor.right;
    }
    return result;
  }

  public List<Integer> postorderTraversal01(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
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
}
