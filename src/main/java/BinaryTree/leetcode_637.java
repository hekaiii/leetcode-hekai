package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/9
 */
public class leetcode_637 {

  public static List<Double> averageOfLevels(TreeNode root) {
    ArrayList<Double> result = new ArrayList<>();
    LinkedList<TreeNode> treeNodes = new LinkedList<>();
    treeNodes.add(root);
    while (!treeNodes.isEmpty()) {
      int size = treeNodes.size();
      double count = 0;
      for (int i = 0; i < size; i++) {
        TreeNode poll = treeNodes.poll();
        count += poll.val;
        if (i == size - 1) {
          result.add((double) (count / size));
        }
        if (poll.left != null) {
          treeNodes.add(poll.left);
        }
        if (poll.right != null) {
          treeNodes.add(poll.right);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {

  }
}
