package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/9
 */
public class leetcode_116 {

  public Node1 connect(Node1 root) {
    if (root == null) {
      return root;
    }
    Deque<Node1> nodes = new ArrayDeque<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        Node1 poll = nodes.poll();
        if (i == size - 1) {
          poll.next = null;
        } else {
          poll.next = nodes.peek();
        }
        if (poll.left != null) {
          nodes.add(poll.left);
        }
        if (poll.right != null) {
          nodes.add(poll.right);
        }
      }
    }
    return root;
  }

  public static void main(String[] args) {

  }
}

class Node1 {
  public int val;
  public Node1 left;
  public Node1 right;
  public Node1 next;

  public Node1() {}

  public Node1(int _val) {
    val = _val;
  }


};
