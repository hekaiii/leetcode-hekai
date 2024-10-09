package ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/1 23:39
 */
public class leetcode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummp = new ListNode(-1);
        dummp.next = head;
        ListNode fast = dummp;
        ListNode slow = dummp;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummp.next;
    }

    public static ListNode removeNthFromEnd01(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.init(1);
        ListNode.print(head);
        ListNode listNode = removeNthFromEnd01(head, 1);
        ListNode.print(listNode);
    }
}
