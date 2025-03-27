package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/9
 */
public class leetcode_116 {

  public Node116 connect(Node116 root) {
    if (root == null) {
      return root;
    }
    Deque<Node116> nodes = new ArrayDeque<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        Node116 poll = nodes.poll();
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

  public Node116 connect01(Node116 root) {
    if (root == null) {
      return root;
    }
    ArrayDeque<Node116> nodes = new ArrayDeque<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        Node116 poll = nodes.poll();
        if (poll.left != null) {
          nodes.add(poll.left);
        }
        if (poll.right != null) {
          nodes.add(poll.right);
        }
        if (i == size - 1) {
          poll.next = null;
        } else {
          poll.next = nodes.peek();
        }
      }
    }
    return root;
  }
  public static void main(String[] args) {

  }
}

