package March_2021;

public class RemoveDuplicatesFromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode hammy = new ListNode(-1, head);
        head = hammy;
        ListNode cursor = head;

        while (cursor.next != null && cursor.next.next != null) {
            ListNode p = cursor.next;
            if (cursor.next.val == p.next.val) {
                while (p.next != null && cursor.next.val == p.next.val) {
                    p = p.next;
                }
                cursor.next = p.next;
                continue;
            }
            cursor = cursor.next;
        }
        return head.next;
    }
}

class ListNode {
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
