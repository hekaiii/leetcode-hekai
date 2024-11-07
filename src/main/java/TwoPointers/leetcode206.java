package TwoPointers;

import ListNode.ListNode;
/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/11/6
 */
public class leetcode206 {

  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = null;
    ListNode fast = head;
    ListNode slow = dummy;
    while (fast != null) {
      ListNode tmp = slow;
      slow = fast;
      fast = fast.next;
      slow.next = tmp;
    }
    return slow;
  }
  public static void main(String[] args) {
    ListNode listNode = ListNode.init(5);
    ListNode.print(listNode);
    ListNode listNode1 = reverseList(listNode);
    ListNode.print(listNode1);
  }
}
