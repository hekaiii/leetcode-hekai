package ListNode;

import javax.swing.table.TableModel;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/9/11
 */
public class Leetcode_24 {
  public static ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode cursor = dummy;
    while (cursor.next != null && cursor.next.next != null) {
      ListNode temp1 = cursor.next;
      ListNode temp2 = cursor.next.next.next;
      cursor.next = cursor.next.next;
      cursor.next.next = temp1;
      temp1.next = temp2;
      cursor = temp1;
    }
    return dummy.next;
  }
  public static ListNode swapPairs01(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null) {
      ListNode tmp = fast;
      fast = fast.next;
      tmp.next = slow;
      slow = tmp;
      if (fast.next.next == null) {
        slow.next = fast;
      }

    }
    return slow;
  }
  public static void main(String[] args) {
    ListNode head = ListNode.init(6);
    ListNode listNode = swapPairs(head);
    ListNode.print(listNode);
  }
}
