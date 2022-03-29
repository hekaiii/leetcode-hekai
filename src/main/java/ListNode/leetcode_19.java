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
}
