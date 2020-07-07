package com.codeforces;

import com.leetcode.Starter.ListNode;

public class AddTwoLinkedList {

    public static void main(String[] args) {


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummyHead = new ListNode(0);
       ListNode current =  dummyHead;
       int x , y, carry = 0, sum;
       while(l1 != null || l2 != null) {
             x = l1 != null ? l1.val : 0;
             y = l2 != null ? l2.val : 0;
             sum =  x + y + carry;
             carry =  sum / 10;
             current.next = new ListNode(sum % 10);
             current = current.next;

             if(l1 != null) l1 = l1.next;
             if(l2 !=  null) l2 = l2.next;
       }
       if(carry > 0) {
           current.next = new ListNode(carry);
       }
       return dummyHead.next;
    }
}