package ListNode;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/9/23
 */
public class leetcode_160 {
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode pA = headA;
    ListNode pB = headB;
    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
      System.out.print("pA:" + (pA == null ? "null" : pA.val));
      System.out.println(" pB:" + (pB == null ? "null" : pB.val));
    }
    return pA;
  }

  public static void main(String[] args) {
    int[] list1 = {2, 6, 4,1};
    int[] list2 = {1, 5, 1,1};
    ListNode l1 = ListNode.createList(list1);
    ListNode l2 = ListNode.createList(list2);
//    ListNode.print(l1);
//    ListNode.print(l2);
    ListNode intersectionNode = getIntersectionNode(l1, l2);
    ListNode.print(intersectionNode);
  }
}
