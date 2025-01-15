package ListNode;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/8/28
 */
public class leetcode_707_01 {


  class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
      this.size = 0;
      this.head = new ListNode(0);
    }
    public int get(int index) {
      if (size == 0 || index >= size) {
        return -1;
      }
      ListNode cursor = new ListNode();
      cursor.next = head;
      for (int i = 0; i <= index; i++) {
        cursor = cursor.next;
      }
      return cursor.val;
    }

    public void addAtHead(int val) {

    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
  }


}
