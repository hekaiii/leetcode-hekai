package review;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/31
 */
public class leetcode_206 {
  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = null;
    ListNode fast = head;
    while (fast != null) {
      ListNode tmp = fast.next;
      fast.next = slow;
      slow = fast;
      fast = tmp;
    }
    return slow;
  }
  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    // 手动链接这些节点形成一个链表
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    ListNode head = node1;

    ListNode listNode = reverseList(head);
    listNode.print(listNode);
  }
}
