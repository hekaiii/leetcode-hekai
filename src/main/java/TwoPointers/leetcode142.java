package TwoPointers;
import ListNode.ListNode;
/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/11/7
 */
public class leetcode142 {
  public static ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) {
        /**
         fast比slow快，他俩此时相当肯定不是因为都到终点了，所有只有可能是有环，在环内相遇了。
         */
        ListNode cursor = head;
        while (cursor != slow) {
          cursor = cursor.next;
          slow = slow.next;
        }
        return slow;
      }
    }
    return null;
  }
  public static void main(String[] args) {
    ListNode listNode = new ListNode(1);
    ListNode next = listNode.next;

  }
}
