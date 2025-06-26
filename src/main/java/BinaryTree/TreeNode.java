package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/11/20
 */
public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;
  int height;

  public TreeNode(int val) {
    this.val = val;
    this.height = 1;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
  public static void printTreeLevelOrder(TreeNode root) {
    if (root == null) {
      System.out.println("[]");
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<String> result = new ArrayList<>();

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node == null) {
        result.add("null");
      } else {
        result.add(String.valueOf(node.val));
        queue.offer(node.left);
        queue.offer(node.right);
      }
    }

    // 去掉尾部多余的 null
    int i = result.size() - 1;
    while (i >= 0 && result.get(i).equals("null")) {
      result.remove(i--);
    }

    System.out.println(result);
  }
}
