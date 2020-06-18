package com.yu.node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoNodes {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode output = new ListNode(0);
        ListNode curr = output;
        StringBuilder builder = new StringBuilder();
        ListNode node1 = l1;
        ListNode node2 = l2;
        int shiNum = 0;
        while (null != node1 && null != node2) {

            int total = node1.val + node2.val + shiNum;
            shiNum = total / 10;
            int geNum = total % 10;

            curr.next = new ListNode(geNum);
            curr = curr.next;

            node1 = node1.next;
            node2 = node2.next;
        }

        return output.next;

    }


}
