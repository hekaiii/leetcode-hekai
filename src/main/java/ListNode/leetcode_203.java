package ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/2/23 23:31
 *
 *
 *解法：
 * 1.直接移除
 * 2.虚头节点移除
 */
public class leetcode_203 {

    public static void main(String[] args) {

    }

    //直接移除
    public ListNode removeElements(ListNode head, int val) {
        //判断头节点是不是需要删除的元素，是的话就一直删除
        while (head != null || head.val == val) {
            head = head.next;
        }
        //现在头节点不是目标元素，判断现在头节点是不是空
        if (head == null) {
            return head;
        }
        //现在头节点不是目标元素，并且不为空，处理后面的元素
        ListNode pre = head;//慢指针？
        ListNode cur = head.next;//快指针，当前链表的下一个元素
        while (cur!= null) {//cur.next!=null，说明遍历没到头，执行下面判断
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //虚头节点移除
    public ListNode removeElements01(ListNode head, int val) {
        ListNode pre = new ListNode(-1, head);
        ListNode cur = head;
        if (head == null) {
            return null;
        }
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return pre.next;
    }

    public ListNode removeElements02(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }


}
