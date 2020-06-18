package com.yu.node;


/**
 * Merge Two Sorted Lists
 * <p>
 * <p>
 * <p>
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class MergeListNode {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        List<Integer> list = new ArrayList<>();
        ListNode listNode = null;
        ListNode head = null;

        while (null != l1) {
            list.add(l1.val);
            if (l1.next == null){
                break;
            }
            l1 = l1.next;
        }

        while (null != l2) {
            list.add(l2.val);
            if (l2.next == null){
                break;
            }
            l2 = l2.next;
        }

        Collections.sort(list);
        if (!list.isEmpty()) {
            listNode = new ListNode(0);
            head = listNode;
            for (int i = 0; i < list.size(); i++) {
                ListNode listNodeNew = new ListNode(list.get(i));
                listNode.next = listNodeNew;
                listNode = listNode.next;
            }
        }

        if (null ==head.next){
            return null;
        }
        return head.next;
    }

    public static void main(String[] args) {

        List<Integer> ids = Arrays.asList(1,2,3,4,0);

        Set<Long> set = ids.stream().filter(v->v!=0).map(Long::new).collect(Collectors.toSet());

        System.out.println(set);
//        ListNode prevHead = null;
//        ListNode head = new ListNode(3);
//
//        prevHead = head;
//        head = new ListNode(2);
//        head.next = prevHead;
//
//        prevHead = head;
//        head = new ListNode(1);
//        head.next = prevHead;
//
//
//
//        ListNode preHead2 = null;
//        ListNode head2 = new ListNode(6);
//
//        preHead2 = head2;
//        head2 = new ListNode(5);
//        head2.next = preHead2;
//
//        preHead2 = head2;
//        head2 = new ListNode(4);
//        head2.next = preHead2;
//
//        ListNode listNode = mergeTwoLists(head, head2);
//        System.out.println(listNode);
    }
}
