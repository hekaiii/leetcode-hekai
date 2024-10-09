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
    if (head == null || head.next == null) {
      return null;
    }
    return null;
  }
}
