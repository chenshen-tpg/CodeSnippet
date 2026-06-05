package main.Coding.Algorithms.Normal.ReverseLinkedList_206;

import main.Coding.Lib.ListNode;

public class TEST {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy;
            dummy = cur;
            cur = next;
        }
        return dummy;
    }
}
