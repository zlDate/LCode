package com.test.leetCode;

/**
 * Created by le on 2017/4/3.
 * 用链表表示非负整数  倒序存储 首节点是最低位（个位） 例如 7-0-8  表示807
 * 输入连个数字求和
 * 输入  2-4-3   5-6-4   即 342+465=807
 * 输出  7-0-8
 */
public class AddTwoNumbersTest {
    public static void main(String[] args) {
        ListNode l1 = int2ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = int2ListNode(9);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(6);
        addTwoNumbers2(l1,l2);
    }

    public static ListNode addTwoNumbers2(ListNode l1,ListNode l2){
        int sum = 0;
        ListNode l = new ListNode(1);
        ListNode tmp = l;
        while (l1 !=null || l2 !=null){
            sum /= 10;
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            //第一次tmp和l的指向都是  new ListNode(1)
            tmp.next = new ListNode(sum%10);
            //修改tmp的指向为  new ListNode(sum%10)  l的指向没有变
            tmp = tmp.next;
        }
        if(sum / 10 == 1){
            tmp.next = new ListNode(1);
        }
        return l.next;
    }


    //只能在int范围内使用 int超范围不能用
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int sum = listNode2Int(l1)+listNode2Int(l2);
        return int2ListNode(sum);
    }
    private static int listNode2Int(ListNode l){
        int sum = 0;
        int tmp = 1;
        while (l !=null){
            sum += tmp*l.val;
            tmp *= 10;
            l = l.next;
        }
        return sum;
    }
    private static ListNode int2ListNode(int i){
        ListNode l = new ListNode(i%10);
        i /= 10;
        //临时记录l的next
        ListNode tmp = l;
        while (i!=0){
            tmp.next = new ListNode(i%10);
            tmp = tmp.next;
            i /= 10;
        }
        return l;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}