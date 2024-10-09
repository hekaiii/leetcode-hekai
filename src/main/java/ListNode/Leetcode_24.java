package ListNode;

/**
 * @Author: hek32
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

  public static void main(String[] args) {
    ListNode head = ListNode.init(6);
    ListNode listNode = swapPairs(head);
    ListNode.print(listNode);
  }
}
