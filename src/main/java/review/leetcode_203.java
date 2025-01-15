package review;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/31
 */
public class leetcode_203 {
  public static ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return head;
    }
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = head;
    while (fast != null) {
      if (fast.val == val) {
        slow.next = fast.next;
      } else {
        slow = fast;
      }
      fast = fast.next;
    }
    return dummy.next;
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

    ListNode listNode = removeElements(head, 3);
    listNode.print(head);
  }
}
