package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/9
 */
public class leetcode_429 {

  public static List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    LinkedList<Node> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      ArrayList<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        Node poll = nodes.poll();
        list.add(poll.val);
        nodes.addAll(poll.children);
      }
      result.add(list);
    }
    return result;
  }

  public static void main(String[] args) {
    List<Node> nodes1 = new ArrayList<>();
    nodes1.add(new Node(5));
    nodes1.add(new Node(6));
    Node node3 = new Node(3, nodes1);
    List<Node> nodes2 = new ArrayList<>();
    nodes2.add(node3);
    nodes2.add(new Node(2));
    nodes2.add(new Node(4));
    Node root = new Node(1, nodes2);
    List<List<Integer>> lists = levelOrder(root);
    for (List<Integer> list : lists) {
      for (Integer i : list) {
        System.out.print(i);
      }
      System.out.println();
    }
  }
}
