package main.Coding.Algorithms.Medium.PrintImmutableLinkedList_1265;

import main.Coding.Lib.ImmutableListNode;


public class Recursive {

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head != null) {
            printLinkedListInReverse(head.getNext());
            head.printValue();
        }
    }
}
