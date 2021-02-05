package Leetcode_2020.August;

public class Aug3 {

    /*给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。
    换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
*/
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //暴力法
        if (headA == null || headB == null) {
            //若有一个链表为空，则不可能有相交
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        for (; curA != null; curA = curA.next) {
            curB = headB;
            for (; curB != null; curB = curB.next) {
                if (curA == curB) {
                    return curA;
                }
            }
        }
        return null;
    }
}

