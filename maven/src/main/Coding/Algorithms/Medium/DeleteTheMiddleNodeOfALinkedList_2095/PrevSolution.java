package main.Coding.Algorithms.Medium.DeleteTheMiddleNodeOfALinkedList_2095;

import main.Coding.Lib.ListNode;

public class PrevSolution {
    public static void main(String[] args) {

    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is middle, prev is node before middle
        prev.next = slow.next;
        return head;
    }
}
