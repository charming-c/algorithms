/*
* 多级双向链表中，除了指向下一个节点和前一个节点指针之外，
* 它还有一个子链表指针，可能指向单独的双向链表。
* 这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，
* 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。

* */
public class 扁平化多级双向链表 {
    class Solution {
        public Node flatten(Node head) {
            Node node1,node2,node3;
            node2 = head;
            if(node2 == null || (node2.next == null && node2.child == null))
                return node2;

            while(node2.child == null && node2.next != null){
                node2 = node2.next;
            }
            if(node2.child != null && node2.next != null){
                node1 = flatten(node2.child);
                node3 = node2.next;
                node2.next = node1;
                node2.child = null;
                node1.prev = node2;
                while(node1.next != null){
                    node1=node1.next;
                }
                node1.next = node3;
                node3.prev = node1;
            }
            if(node2.child != null && node2.next == null){
                node2.next=node2.child;
                node2.child.prev = node2;
                node2.child = null;
                node2 = flatten(node2.next);
            }
            return head;
        }
    }
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
