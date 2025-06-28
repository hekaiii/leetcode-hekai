package ListNode;

/**
 * @author hekai
 * @date 2025/6/23 20:33
 * @description 快慢指针+反转链表
 */
public class leetcode_234 {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //奇偶区别对待
        if (fast == null) { //偶数
            slow = reverse(slow);
        } else {//奇数
            slow = reverse(slow.next);
        }
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(root));
    }
}
