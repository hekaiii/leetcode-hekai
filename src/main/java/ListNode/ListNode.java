package ListNode;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/8/27
 */
public class ListNode {

  int val;
  ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  //遍历打印方法
  public static void print(ListNode listNode) {
    while (listNode != null) {
      System.out.print(listNode.val + " -> ");
      listNode = listNode.next;
    }
    System.out.println("null");
  }
}
