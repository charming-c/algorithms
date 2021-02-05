package Leetcode_2020.August;

public class Aug6 {
    /*给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
    请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
    请尝试使用原地算法完成。
    你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。*/
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode oddEvenList(ListNode head) {
        ListNode node1=new ListNode();
        ListNode node2=new ListNode();
        ListNode node3=new ListNode();
        node1=head;
        if(node1==null)
            return null;
        node2=node1.next;
        node3=node2;
        if(node2==null)
            return head;
        while(node2.next!=null && node2.next.next!=null){
            node1.next=node2.next;
            node1=node2.next;
            node2.next=node1.next;
            node2=node1.next;
        }
        if(node2.next==null){
            node1.next=node3;
        }
        else if(node2.next.next==null){
            node1.next=node2.next;
            node2.next=null;
            node1=node1.next;
            node1.next=node3;
        }
        return head;
    }

}
