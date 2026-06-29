package main.Coding.Algorithms.Medium.AddTwoNumbers_2;

import main.Coding.Lib.ListNode;

public class TEST {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 !=null || carry != 0) {

            int currentL1 = 0;
            int currentL2 = 0;
            if (l1  == null) {
                currentL1 = 0;
            } else {
                currentL1 = l1.val;
            }
            if (l2  == null) {
                currentL2 = 0;
            } else {
                currentL2 = l2.val;
            }
            int sum = carry + currentL1 + currentL2;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 !=null ) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
