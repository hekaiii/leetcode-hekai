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

        ListNode listNode = removeElements03(head, 3);
        listNode.print(head);

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

    public static ListNode removeElements03(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cursor = dummy;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }
        return dummy.next;
    }

    public static ListNode removeElements04(ListNode head, int val){
        ListNode dummy = new ListNode();
        ListNode cursor = new ListNode();
        dummy.next = head;
        cursor = dummy;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;//改变节点索引的操作
            } else {
                cursor = cursor.next;
            }
        }
        return dummy.next;
    }

    public static ListNode removeElements05(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head.val == val) {
            if (head.next != null) {
                head = head.next;
            } else {
                return null;
            }
        }
        ListNode cursor = new ListNode();
        cursor = head;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }
        return head;
    }
}
