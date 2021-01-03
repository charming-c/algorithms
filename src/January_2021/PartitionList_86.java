package January_2021;

//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
//
//        你应当保留两个分区中每个节点的初始相对位置。
//
//         
//
//        示例：
//
//        输入：head = 1->4->3->2->5->2, x = 3
//        输出：1->2->2->4->3->5

public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // 给链表的头节点加上一个空节点，方便后面比较值
        ListNode head2 = new ListNode(-1);
        head2.next = head;
        head = head2;
        ListNode node1 = head;

        // 找到距离值比x大或者相等的节点的最近的节点
        while (node1.next != null) {
            if (node1.next.val >= x) {
                break;
            }
            node1 = node1.next;
        }

        // 如果最近的节点已经走到链表末尾，则直接返回head.next
        if (node1.next == null) return head.next;

        // 如果没有，则将p指向第一个比x大的节点，node2指向p的下一个
        // 比较node2的值的大小与x的关系，进行链表位置的修改，直至node2走到链表末尾
        ListNode p = node1.next, node2 = p.next;
        while (node2 != null) {
            if (node2.val < x) {
                p.next = node2.next;
                node2.next = node1.next;
                node1.next = node2;
                node1 = node1.next;
                node2 = p.next;
            } else {
                p = p.next;
                node2 = node2.next;
            }
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
