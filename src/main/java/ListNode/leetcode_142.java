package ListNode;

import java.util.LinkedHashSet;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/9/24
 */
public class leetcode_142 {
  //垃圾解法
  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode cursor = head;
    LinkedHashSet<ListNode> res = new LinkedHashSet<ListNode>();
    while (cursor != null) {
      if (res.add(cursor)) {
        cursor = cursor.next;
      } else {
        return cursor;
      }
    }
    return null;
  }

  public ListNode detectCycle01(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next!=null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        ListNode l1 = head;
        ListNode l2 = slow;
        while (l1 != l2) {
          l1 = l1.next;
          l2 = l2.next;
        }
        return l1;
      }
    }
    return null;
  }
}
