package ListNode;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.util.List;

/**
 * @author hekai
 * @date 2025/6/23 20:33
 * @description TODO
 */
public class leetcode_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int count = 1;
        ListNode dummy = head;
        while (dummy.next != null) {
            count++;
            dummy = dummy.next;
        }
        int[] list = new int[count];
        list[0] = head.val;
        dummy = head;
        int a = 1;
        while (dummy.next != null) {
            list[a++] = dummy.next.val;
            dummy = dummy.next;
        }
        for (int i = 0; i < list.length / 2; i++) {
            if (list[i] != list[list.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
    //快慢指针+反转链表
    public boolean isPalindrome01(ListNode head) {

    }
    public static void main(String[] args) {

    }
}
