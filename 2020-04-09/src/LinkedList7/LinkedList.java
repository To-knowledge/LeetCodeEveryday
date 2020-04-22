package LinkedList7;

import Util.ListNode;

public class LinkedList {
    public static void main(String[] args) {
        System.out.println();
    }
}

/*反转链表*/
/*迭代法*/
class Solution {
    public ListNode reverseList(ListNode head) {
        //定义新的头节点
        ListNode newHead = null;
        ListNode iterator = head;
        //一个中间辅助变量
        ListNode tmp = null;
        while(iterator != null){
            tmp = iterator.next;
            iterator.next = newHead;
            newHead = iterator;
            iterator = tmp;
        }
        return newHead;
    }
}

/*递归法*/
class Solution1 {
    public ListNode reverseList(ListNode head) {

        if(head == null)  return null;
        if(head.next == null)   return head;

        ListNode tmp = head.next;
        ListNode res = reverseList(head.next);
        tmp.next = head;
        head.next = null;

        return res;
    }
}