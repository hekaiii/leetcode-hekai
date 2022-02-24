package ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/2/24 13:21
 */

class ListNode01 {
    int val;
    ListNode01 next;

    public ListNode01() {
    }

    public ListNode01(int val) {
        this.val = val;
    }

    public ListNode01(int val, ListNode01 next) {
        this.val = val;
        this.next = next;
    }
}

public class leetcode_707 {
    int size;
    ListNode01 head;

    //MyLinkedList 初始化
    public leetcode_707() {
        int size = 0;
        head = new ListNode01(0);
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode01 dummy = head;
        for (int i = 0; i <= index ; i++) {
            dummy = dummy.next;//自增
        }
        return dummy.val;
    }

    public void addAtHead(int val) {
        ListNode01 newhead = new ListNode01(val);
        newhead.next = head;
        head = newhead;
    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}
