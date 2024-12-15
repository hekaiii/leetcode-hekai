package BinaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/15
 */
public class leetcode_654 {
  public static TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums.length == 1) {
      return new TreeNode(nums[0]);
    }
    return getResult(nums);
  }

  private static TreeNode getResult(int[] nums) {
    if (nums.length == 0) {
      return null;
    }

    int index = 0;
    int temp = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > temp) {
        index = i;
        temp = nums[i];
      }
    }

    TreeNode root = new TreeNode(nums[index]);

    int[] left = new int[index];
    for (int i = 0; i < index; i++) {
      left[i]=nums[i];
    }
    int[] right = new int[nums.length-index-1];
    for (int i = index+1; i < nums.length; i++) {
      right[i-index-1]=nums[i];
    }
    root.left = getResult(left);
    root.right = getResult(right);
    return root;
  }

  //gpt提供方法
  public static TreeNode constructMaximumBinaryTree01(int[] nums) {
    return construct(nums, 0, nums.length - 1);
  }

  private static TreeNode construct(int[] nums, int start, int end) {
    // Base case: if the range is invalid, return null
    if (start > end) {
      return null;
    }

    // Find the maximum value and its index in the current range
    int maxIndex = start;
    for (int i = start; i <= end; i++) {
      if (nums[i] > nums[maxIndex]) {
        maxIndex = i;
      }
    }

    // Create the root node with the maximum value
    TreeNode root = new TreeNode(nums[maxIndex]);

    // Recursively construct the left and right subtrees
    root.left = construct(nums, start, maxIndex - 1);
    root.right = construct(nums, maxIndex + 1, end);

    return root;
  }

  public static void main(String[] args) {
    int[] a = {3, 2, 1, 6, 0, 5};
    TreeNode treeNode = constructMaximumBinaryTree(a);
  }
}
