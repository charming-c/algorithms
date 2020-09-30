package September;/*
* 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.

* */

import August.Aug3;

public class 两两交换链表中的节点 {
    public Aug3.ListNode swapPairs(Aug3.ListNode head) {
        if(head == null || head.next == null)
            return head;

        Aug3.ListNode firstNode = head;
        Aug3.ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;

    }

}

