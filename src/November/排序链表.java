package November;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//        进阶：
//
//        你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//         
//
//        示例 1：
//
//
//        输入：head = [4,2,1,3]
//        输出：[1,2,3,4]


public class 排序链表 {
    public class ListNode {
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        //切割成两段链表
        ListNode node = cut(head);
        ListNode head2 = node.next;
        node.next = null;

        return merge(sortList(head), sortList(head2));

    }

    public ListNode cut(ListNode head) {
        ListNode fast = head;
        ListNode low = head;

        //如果只有少于个节点，没有排序的必要，直接返回头节点
        if (head == null || head.next == null) return null;

        //将链表分割成两个相等的部分
        while (fast.next != null && fast.next.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) return null;
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.val <= head2.val) {
            head1.next = merge(head1.next, head2);
            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }
}
