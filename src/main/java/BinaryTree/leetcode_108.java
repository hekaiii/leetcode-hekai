package BinaryTree;

import static BinaryTree.leetcode_102.levelOrder01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/26
 */
public class leetcode_108 {

//  //层序
//  public static TreeNode sortedArrayToBST(int[] nums) {
//    if (nums.length == 1) {
//      return new TreeNode(nums[0]);
//    }
//    int size = nums.length / 2;
//    TreeNode root = new TreeNode(nums[size]);
//    TreeNode tmp = root;
//    for (int i = size - 1; i >= 0; i--) {
//      tmp.left = new TreeNode(nums[i]);
//      tmp = tmp.left;
//    }
//    tmp = root;
//    for (int i = size + 1; i < nums.length; i++) {
//      tmp.right = new TreeNode(nums[i]);
//      tmp = tmp.right;
//    }
//    return root;
//  }

  //递归
  public static TreeNode sortedArrayToBST01(int[] nums) {
    return getResult(nums, 0, nums.length - 1);
  }

  private static TreeNode getResult(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = getResult(nums, start, mid - 1);
    node.right = getResult(nums, mid + 1, end);
    return node;
  }


  public static void main(String[] args) {
    int[] a = {-10, -3, 0, 5, 9};
    TreeNode treeNode = sortedArrayToBST01(a);
    List<List<Integer>> list = levelOrder01(treeNode);
    System.out.println(String.valueOf(list));
  }
}
