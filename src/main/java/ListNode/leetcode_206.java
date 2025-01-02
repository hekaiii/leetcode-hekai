package ListNode;

import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/1 23:14
 */
public class leetcode_206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = null;
        ListNode cur = head;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode temp = null;
        ListNode cur = head;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static ListNode reverseList02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        ListNode result = new ListNode();
        ListNode cursor = result;
        while (!stack.empty()) {
            cursor.next = new ListNode(stack.pop());
            cursor = cursor.next;
        }
        return result.next;
    }

    public static ListNode reverseList03(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode temp = null;
        ListNode cursor = head;
        while (cursor != null) {
            temp = cursor.next;
            cursor.next = pre;
            pre = cursor;
            cursor = temp;
        }
        return pre;
    }
    public static ListNode reverseList04(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null) {
            ListNode tmp = fast;
            fast = fast.next;
            tmp.next = slow;
            slow = tmp;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode listNode = ListNode.init(5);
        ListNode listNode1 = reverseList04(listNode);
        ListNode.print(listNode1);
    }


}
