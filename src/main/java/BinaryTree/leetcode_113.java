package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/13
 */
public class leetcode_113 {

  public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    ArrayList<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayList<Integer> list = new ArrayList<>();
    list.add(root.val);
    getPathSum(root,list,targetSum-root.val,result);
    return result;
  }

  private static void getPathSum(TreeNode node,ArrayList<Integer> list,int targetSum,ArrayList<List<Integer>> result) {
    if (node.left == null && node.right == null && targetSum == 0) {
      ArrayList<Integer> integers = new ArrayList<>();
      integers.addAll(list);
      result.add(integers);
    }
    if (node.left != null) {
      list.add(node.left.val);
      getPathSum(node.left, list, targetSum - node.left.val,result);
      list.remove(list.size() - 1);
    }
    if (node.right != null) {
      list.add(node.right.val);
      getPathSum(node.right, list, targetSum - node.right.val,result);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    List<List<Integer>> lists = pathSum(root, 3);
    for (List<Integer> list : lists) {
      System.out.println(Arrays.toString(new List[]{list}));
    }
  }
}

