package TwoPointers;
import ListNode.ListNode;
/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/11/6
 */
public class leetcode19 {

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    int count = 0;
    ListNode cursor = head;
    while (cursor != null) {
      count++;
      cursor = cursor.next;
    }
    ListNode dummy = new ListNode();
    ListNode newHead = new ListNode();
    dummy.next = head;
    newHead = dummy;
    for (int i = 0; i <= count - n; i++) {
      if (i != count - n) {
        dummy = dummy.next;
      } else {
        dummy.next = dummy.next.next;
      }
    }
    return newHead.next;
  }
  public static void main(String[] args) {
    ListNode listNode = ListNode.init(1);
//    ListNode listNode = new ListNode(1);
    ListNode.print(listNode);
    ListNode listNode1 = removeNthFromEnd(listNode, 1);
    ListNode.print(listNode1);
  }
}
