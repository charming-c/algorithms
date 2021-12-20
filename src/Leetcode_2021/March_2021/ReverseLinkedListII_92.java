package Leetcode_2021.March_2021;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
//         
//
//        示例 1：
//
//
//        输入：head = [1,2,3,4,5], left = 2, right = 4
//        输出：[1,4,3,2,5]

public class ReverseLinkedListII_92 {

    // 第二次写了，虽然做出来了，但是不够好，不够快
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left >= right) return head;
        ListNode node1 = head;
        ListNode node2 = head;
        while (right != 1) {
            node2 = node2.next;
            right--;
        }

        if (left == 1) return reverse(node1, node2.next);
        while (left != 2) {
            node1 = node1.next;
            left--;

        }

        node1.next = reverse(node1.next, node2.next);
        return head;
    }

    // 半年前一位很妙很妙的递归反转链表，现在自己也能写出来了，牛蛙牛蛙！
    public ListNode reverse(ListNode head, ListNode right) {
        if (head == right || head.next == right) return head;
        ListNode node = head;
        head = reverse(head.next, right);
        node.next.next = node;
        node.next = right;
        return head;

    }

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
}
