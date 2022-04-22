package Leetcode.Leetcode_2020.October;

public class 返回倒数第K个节点 {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
        public int kthToLast(ListNode head, int k) {
            int n=0;
            int m=0;
            ListNode node = head;
            while(head.next != null){
                head = head.next;
                n++;
            }
            m=n-k+1;
            while(m!=0){
                node = node.next;
                m--;
            }
            return node.val;
        }
}
