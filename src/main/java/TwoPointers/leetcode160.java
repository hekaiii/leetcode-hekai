package TwoPointers;

import ListNode.ListNode;
/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/11/6
 */
public class leetcode160 {

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode A = headA;
    ListNode B = headB;
    while (A != B) {
      A = A == null ? B : A.next;
      A = B == null ? A : B.next;
    }
    return A;
  }

  public static void main(String[] args) {


  }
}
