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

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next; //1.保存下一步
            head.next = pre; //2.当前步可以掉头了
            pre = head; //3.后一步站当前步
            head = tmp; //4.当前步前进一步
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.init(5);
        ListNode listNode1 = reverseList(listNode);
        ListNode.print(listNode1);
    }


}
