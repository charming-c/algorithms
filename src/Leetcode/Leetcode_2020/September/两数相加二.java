package Leetcode.Leetcode_2020.September;
/*
        给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
        你可以假设除了数字 0 之外，这两个数字都不会以零开头。
        进阶：
        如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
        示例：
        输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 8 -> 0 -> 7
        */

import Leetcode.Leetcode_2020.August.Aug3;

import java.util.Deque;
import java.util.LinkedList;

public class 两数相加二 {
    public Aug3.ListNode addTwoNumbers(Aug3.ListNode l1, Aug3.ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<Integer>();
        Deque<Integer> stack2 = new LinkedList<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        Aug3.ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            Aug3.ListNode curnode = new Aug3.ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}
