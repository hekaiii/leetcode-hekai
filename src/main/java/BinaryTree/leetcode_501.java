package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/18
 */
public class leetcode_501 {
  //迭代
  public int[] findMode(TreeNode root) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    LinkedList<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        TreeNode poll = nodes.poll();
        hm.put(poll.val, hm.getOrDefault(poll.val, 0) + 1);
        if (poll.left != null) {
          nodes.add(poll.left);
        }
        if (poll.right != null) {
          nodes.add(poll.right);
        }
      }
    }
    int maxCount = 0;
    ArrayList<Integer> integers = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
      maxCount = Math.max(maxCount, entry.getValue());
    }
    for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
      if (entry.getValue() == maxCount) {
        integers.add(entry.getKey());
      }
    }
    int[] intArray = new int[integers.size()];
    for (int i = 0; i < integers.size(); i++) {
      intArray[i] = integers.get(i);
    }
    return intArray;
  }

  //递归遍历+hashmap统计
  static int maxCount = 0;
  static int count = 0;
  static TreeNode pre = null;
  static ArrayList<Integer> result = new ArrayList<>();
  public static int[] findMode01(TreeNode root) {
    if (root.left == null && root.right == null) {
      return new int[]{root.val};
    } else {
      int count = 0;
      inorder(root);
      int[] a = new int[result.size()];
      int index = 0;
      Iterator<Integer> iterator = result.iterator();
      while (iterator.hasNext()) {
        a[index] = iterator.next();
        index++;
      }
      return a;
    }
  }

  private static void inorder(TreeNode node) {
    if (node == null) {
      return;
    }
    //左
    inorder(node.left);
    //中
    if (pre == null || pre.val != node.val) {
      count = 1;
    } else {
      count++;
    }

    if (count == maxCount) {
      result.add(node.val);
    } else if (count > maxCount) {
      result.clear();
      result.add(node.val);
      maxCount = count;
    }
    pre = node;
    //右
    inorder(node.right);
  }

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(0);
    treeNode.left.left = new TreeNode(0);
    treeNode.left.left.left = new TreeNode(0);
    treeNode.left.right = new TreeNode(0);
    treeNode.right = new TreeNode(1);
    treeNode.right.left = new TreeNode(1);
    treeNode.right.right = new TreeNode(1);
    int[] mode01 = findMode01(treeNode);
    System.out.println(Arrays.toString(mode01));
  }
}
