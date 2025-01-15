package BinaryTree;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.management.relation.RelationSupport;

/**
 * @Author: hekai
 * @Description: 递归 层序
 * @Date: 2024/12/12
 */
public class leetcode_404 {

  //递归
  public static int sumOfLeftLeaves01(TreeNode root) {
    ArrayList<Integer> integers = new ArrayList<>();
    getLeftSum(root, integers);
    int result = 0;
    for (Integer integer : integers) {
      result += integer;
    }
    return result;
  }

  private static void getLeftSum(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }
    if (node.left != null && node.left.left == null && node.left.right == null) {
      list.add(node.left.val);
    }
    getLeftSum(node.left, list);
    getLeftSum(node.right, list);
  }

  //递归
  public int sumOfLeftLeaves02(TreeNode root) {
    return 0;
  }
  //递归
  public int sumOfLeftLeaves03(TreeNode root) {
    return 0;
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    System.out.println(sumOfLeftLeaves01(root));
  }
}
