package Leetcode_2021.November_2021;

//给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//         
//
//        示例 1：
//
//
//
//        输入：head = [4,2,1,3]
//        输出：[1,2,3,4]

public class OfferII_077 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        var secondHead = sort(head);
        head = sortList(head);
        secondHead = sortList(secondHead);
        return merge(head, secondHead);

    }

    public ListNode sort(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        var newHead = slow.next;
        slow.next = null;

        return newHead;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }

        if (head1 != null) {
            cur.next = head1;
        } else {
            cur.next = head2;
        }

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}