package ListNode;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/8/28
 */
public class test {

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

//    ListNode dummy = new ListNode();
//    dummy.next = head;
////    dummy.print(head);
//    ListNode cursor = dummy;
//    while (cursor.next != null) {
//      if (cursor.val == 1) {
//        cursor.next = cursor.next.next;
//      } else {
//        cursor = cursor.next;
//      }
//    }
//    ListNode listNode = leetcode_203.removeElements03(head, 1);
//    ListNode.print(listNode);
//    System.out.println();
      ListNode listNode = leetcode_206.reverseList02(head);
      ListNode.print(listNode);
  }
  public static int get(ListNode head,int index) {
    ListNode cursor = new ListNode();
    cursor.next = head;
    for (int i = 0; i <= index; i++) {
      cursor = cursor.next;
    }
    return cursor.val;
  }
}
