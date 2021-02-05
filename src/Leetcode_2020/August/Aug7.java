package Leetcode_2020.August;

public class Aug7 {
    /*给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
    有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
*/
    /*解题思路：快慢指针在环中最终会相遇*/
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
      }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head==null){
            return null;
        }else if(head.next==null){
            return null;
        }
        while(fast != null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                break;
        }
        if(fast != slow)
            return null;
        fast=head;
        /*
        * 这里为什么要让快指针回到开头并且速度变为和慢指针一样呢？
        *
        * 由前面可知，快指针的速度是蛮指针的两倍，------（1）
        * 而两者能相遇，快指针一定比慢指针多在环里跑了n圈（这里针对慢指针每次只走一步，快指针每次多走一步），
        * 又由于（1），所以慢指针走的路程也是一个环的路程
        * 让快慢指针一步一步走，快指针从头走，慢指针接着走
        * 走过链表头到环头的距离
        * 快指针到环头，慢指针整个过程共走一个环加链表头到环头的距离
        * 所以他们会在环头相遇
        * */
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
