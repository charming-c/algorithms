package Leetcode.Leetcode_2020.November;

//对链表进行插入排序。
//
//
//        插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//        每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
//         
//
//        插入排序算法：
//
//        插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
//        每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
//        重复直到所有输入数据插入完为止。
//         
//
//        示例 1：
//
//        输入: 4->2->1->3
//        输出: 1->2->3->4
//        示例 2：
//
//        输入: -1->5->3->4->0
//        输出: -1->0->3->4->5

public class 对链表进行插入排序 {

    //* Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //将这个链表直接拆成两个链表，一个是排好序的，另一个则是要进行插入的
    //针对插入的位置为头部尾部和中部，都有不同的操作，写不同的算法
    public ListNode insertionSortList1(ListNode head) {
        ListNode node1;
        ListNode node2;
        ListNode node3;
        ListNode tail;
        ListNode p;
        if (head == null || head.next == null) return head;
        tail = head;
        node2 = head.next;
        head.next = null;
        while (node2 != null) {
            node1 = head;
            p = node2.next;
            while (node1 != null && node2.val >= node1.val) {
                node1 = node1.next;
            }
            if (node1 == null) {
                tail.next = node2;
                node2.next = null;
                tail = node2;
                node2 = p;
                continue;
            }
            if (node2.val < node1.val) {
                if (node1 == head) {
                    head = node2;
                    node2.next = node1;
                } else {
                    node3 = head;
                    while (node3.next != node1) {
                        node3 = node3.next;
                    }
                    node3.next = node2;
                    node2.next = node1;
                }
            }
            node2 = p;
        }
        return head;
    }
}
