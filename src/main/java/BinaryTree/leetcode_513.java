package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/13
 */
public class leetcode_513 {
  //层序方法
  public static int findBottomLeftValue(TreeNode root) {
    LinkedList<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    while (!nodes.isEmpty()) {
      ArrayList<Integer> result = new ArrayList<>();
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        TreeNode poll = nodes.poll();
        result.add(poll.val);
        if (poll.left != null) {
          nodes.add(poll.left);
        }
        if (poll.right != null) {
          nodes.add(poll.right);
        }
      }
      arrayLists.add(result);
    }
    ArrayList<Integer> integers = arrayLists.get(arrayLists.size() - 1);
    return integers.get(0);
  }

  //递归
  int MaxDepth = Integer.MIN_VALUE;
  int result = 0;
  public  int findBottomLeftValue01(TreeNode root) {
    getResult(root,1);
    return result;
  }

  private void getResult(TreeNode node, int depth) {
    if (depth > MaxDepth) {
      MaxDepth = depth;
      result = node.val;
    }
    if (node.left != null) {
      getResult(node.left, depth+1);
    }
    if (node.right != null) {
      getResult(node.right, depth+1);
    }
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(4);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(6);
    System.out.println(findBottomLeftValue(root));
  }
}
