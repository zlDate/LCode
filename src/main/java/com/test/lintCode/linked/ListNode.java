package com.test.lintCode.linked;

/**
 * Created by le on 2017/4/21.
 * 单向链表
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}
