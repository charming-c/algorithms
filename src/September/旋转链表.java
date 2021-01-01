package September;
/*
*
*给定一个链表，September.旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
*
*
* */

public class 旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode node1 = head;
        int n = 1;
        if (head == null || head.next == null) {
            return head;
        }
        while (node1.next != null) {
            node1 = node1.next;
            n++;
        }
        if (k >= n) {
            k = k % n;
        }
        node1.next = head;
        while (n - k != 0) {
            head = head.next;
            n--;
        }
        while (node1.next != head) {
            node1 = node1.next;
        }
        node1.next = null;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
