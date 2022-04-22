package Leetcode.Leetcode_2020.November;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//        示例：
//
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4


public class 合并两个有序链表 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

//    纪念一下第一次第一下提交就过了的题目，虽然很简单，但我相信这是一个里程碑，哈哈哈哈
//    这道题的思路就是每次比较节点的大小，利用递归获得深层次的有序链表，只需考虑最后返回的是l1，还是l2就可以
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null){
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
