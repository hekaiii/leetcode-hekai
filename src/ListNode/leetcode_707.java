package ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/2/24 13:21
 */

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class leetcode_707 {
    int size;
    ListNode head;

    //MyLinkedList 初始化
    public leetcode_707() {
        int size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode dummy = head;
        for (int i = 0; i <= index ; i++) {
            dummy = dummy.next;//自增
        }
        return dummy.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * 在链表中的第 index 个节点之前添加值为 val  的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果index小于0，则在头部插入节点。
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            return;
        }
        ListNode pre = head;
        ListNode val1 = new ListNode(val);
        size++;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        val1.next = pre.next;
        pre.next = val1;
    }

    /**
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        if (index >= size) {
            return;
        }
        ListNode pre = new ListNode();
        pre = head;
        for (int i = 0; i <index ; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
