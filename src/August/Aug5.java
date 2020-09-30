package August;

public class Aug5 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    /*
    * 自己的思路：循环遍历一次链表，指示为node1，
    * 每次检查以下它之后第n个节点node2，
    * 若node2的next是null，说明node1是倒数第n+1个节点，直接删数据，返回头结点
    * 若node2本身就是null，说明n为链表长度，返回第二个节点作为头节点
    * */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode node1=head;
        ListNode node2;
        while(node1!=null){
            node2=node1;
            for(int i=0;i<n;i++){
                node2=node2.next;
            }
            if(node2==null){
                head=head.next;
                return head;
            }
            if(node2.next==null){
                node1.next=node1.next.next;
                return head;
            }
            node1=node1.next;
        }
        return null;
    }

    /*
    * 第一个指针从列表的开头向前移动 n+1 步，
    * 而第二个指针将从列表的开头出发。
    * 现在，这两个指针被 n个结点分开。
    * 我们通过同时移动两个指针向前来保持这个恒定的间隔，
    * 直到第一个指针到达最后一个结点。
    * 此时第二个指针将指向从最后一个结点数起的第 n 个结点。
    * 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
    * */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
