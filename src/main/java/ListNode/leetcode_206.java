package ListNode;

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

    public static void main(String[] args) {
        ListNode listNode = ListNode.init(5);
        ListNode.print(listNode);
        ListNode listNode1 = reverseList03(listNode);
        ListNode.print(listNode1);
    }


}
