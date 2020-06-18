package com.yu.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 23. Merge k Sorted Lists
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class KSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode result = null;
        List<Integer> listNodes = new ArrayList<>();
        for (ListNode list : lists) {

            while (null != list){
                listNodes.add(list.val);
                if (null == list.next){
                    break;
                }
                list = list.next;
            }
        }

        Collections.sort(listNodes);
        if (!listNodes.isEmpty()) {
            ListNode head = new ListNode(0);
            result = head;
            for (int i = 0; i < listNodes.size(); i++) {
                ListNode listNodeNew = new ListNode(listNodes.get(i));
                head.next = listNodeNew;
                head = head.next;
            }
        }

        if (result == null || null == result.next){
            return null;
        }

        return result.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode result =  head;
        for (int i = 1; i < 4; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }

        ListNode head1 = new ListNode(0);
        ListNode result1 =  head1;
        for (int i = 1; i < 4; i++) {
            head1.next = new ListNode(i);
            head1 = head1.next;
        }


        ListNode head2 = new ListNode(0);
        ListNode result2 =  head2;
        for (int i = 1; i < 4; i++) {
            head2.next = new ListNode(i);
            head2 = head2.next;
        }



        ListNode[] listNodes = {
                result.next,
                result1.next,
                result2.next
        };


        ListNode so = mergeKLists(listNodes);
        System.out.println(so);
    }

}
