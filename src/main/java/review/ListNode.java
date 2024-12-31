package review;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/31
 */
public class ListNode {

  public int val;
  public ListNode next;

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

  public static ListNode init(int n) {
    if (n <= 0) {
      return null; // 如果 n 小于等于 0，则返回空链表
    }

    // 创建头节点
    ListNode head = new ListNode(1);
    ListNode current = head;

    // 创建剩下的节点
    for (int i = 2; i <= n; i++) {
      current.next = new ListNode(i); // 创建新的节点并连接
      current = current.next; // 移动到下一个节点
    }

    return head; // 返回头节点
  }

  public static ListNode createList(int[] values) {
    if (values.length == 0) {
      return null;
    }

    ListNode head = new ListNode(values[0]);
    ListNode current = head;

    for (int i = 1; i < values.length; i++) {
      current.next = new ListNode(values[i]);
      current = current.next;
    }

    return head;
  }
}
