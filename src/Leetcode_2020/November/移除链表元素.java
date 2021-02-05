package Leetcode_2020.November;

//删除链表中等于给定值 val 的所有节点。
//
//        示例:
//
//        输入: 1->2->6->3->4->5->6, val = 6
//        输出: 1->2->3->4->5

public class 移除链表元素 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode cur1;
        ListNode cur2;
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return head;
        cur1 = head;
        cur2 = cur1.next;
        while (cur2 != null) {
            if (cur2.val != val) {
                cur1 = cur1.next;
                cur2 = cur2.next;
                continue;
            }
            if (cur2.val == val) {
                cur1.next = cur2.next;
                cur2 = cur2.next;
            }
        }
        return head;
    }
}
