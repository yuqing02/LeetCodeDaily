package com.yu.node;//struct ListNode {
//        *     int val;
//        *     ListNode *next;
//        *     ListNode(int x) : val(x), next(NULL) {}
//        * };

import lombok.var;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RemoveDuplicatesFromSortedList0307 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode cur;
        while (head.next != null){

            if (head.next.val == head.val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {
//        Date d1 = new Date(Date.parse(""));
//        var endTime1 = new Date(Date.parse("2018,09,14"));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
           Date date = df.parse("2020-01-12");
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int i = c.get(Calendar.WEEK_OF_YEAR);
            System.out.println(i);
        } catch (ParseException e) {
            e.printStackTrace();
        }


//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(2);
//        listNode.next.next.next = new ListNode(2);
//
//        ListNode result = deleteDuplicates(listNode);
//        System.out.println(result);
    }
}
