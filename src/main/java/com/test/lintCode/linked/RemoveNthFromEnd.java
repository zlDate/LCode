package com.test.lintCode.linked;

/**
 * Created by le on 2017/4/21.
 * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点
 * 给出链表1->2->3->4->5->null和 n = 2.
 * 删除倒数第二个节点之后，这个链表将变成1->2->3->5->null.
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ListNode head = new ListNode(1,new ListNode(2,null));
        removeNthFromEnd(head,2);

    }

    /**
     * 设置两个指针 第一个先走n步 然后同时开始走
     * @param head
     * @param n
     * @return
     */
    static ListNode removeNthFromEnd(ListNode head, int n) {
        int index1=0;
        ListNode next1 = new ListNode(0);
        next1.next=head;
        ListNode next2 = new ListNode(0);
        next2.next=head;
        while (next1.next!=null){
            index1++;
            next1 = next1.next;
            if(index1>n){
                next2 = next2.next;
            }
        }
        //此时next2应该指向的是要删除元素的上一个元素
        if(next2.next!=null) next2.next = next2.next.next;
        else return null;
        //如果index1<=n 则删除的是head元素 所以不能返回head
        if(index1<=n){
            return next2.next;
        }
        return head;
    }


}
