package BinaryTree;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
import java.util.ArrayList;
import java.util.List;
import java.util.spi.CurrencyNameProvider;

/**
 * @Author: hekai
 * @Description:
 * 回溯：current.remove(current.size() - 1);
 * 拉完屎冲干净，留给下一个人，将这次操作连带的东西清除掉，不干扰同深度的另一个叶子节点操作
 * @Date: 2024/12/12
 */
public class leetcode_257 {

  public static List<String> binaryTreePaths(TreeNode root) {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Integer> current = new ArrayList<>();
    getResult(root, current, result);
    return result;
  }

  private static void getResult(TreeNode node, ArrayList<Integer> current, ArrayList<String> result) {
    if (node != null && node.left == null && node.right == null) {
      StringBuffer sb = new StringBuffer();
      for (Integer s : current) {
        sb.append(s).append("->");
      }
      sb.append(node.val);
      result.add(sb.toString());
    }

    if (node.left != null) {
      current.add(node.val);
      getResult(node.left,current,result);
      current.remove(current.size() - 1);
    }
    if (node.right != null) {
      current.add(node.val);
      getResult(node.right,current,result);
      current.remove(current.size() - 1);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    List<String> strings = binaryTreePaths(root);
    for (String string : strings) {
      System.out.println(string);
    }
  }
}
