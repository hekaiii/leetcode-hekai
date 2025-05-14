package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/14
 */
public class leetcode_337 {

  public static int rob(TreeNode root) {
    int[] result = dfs(root);
    return Math.max(result[0], result[1]);
  }

  //递归三部曲 定义出参入参、终止条件、方法体
  // int[0]不偷,int[1]偷
  public static int[] dfs(TreeNode node) {
    if (node == null) {
      return new int[2];
    }
    //后序遍历 左右中
    int[] left = dfs(node.left);
    int[] right = dfs(node.right);
    int[] result = new int[2];
    //当前节点不偷的情况下，最大收益
    result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    result[1] = left[0] + node.val + right[0];
    return new int[]{result[0], result[1]};
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(3);
    System.out.println(rob(root));
  }
}
