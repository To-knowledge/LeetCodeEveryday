package xiao.LinkedList7;

import Util.ListNode;

public class LinkedList {
    public static void main(String[] args) {
        System.out.println();
    }
}

/*寻找链表的倒数第k个节点*/

class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        int size = 0;
        ListNode iterator = head;
        while(iterator != null){
            size++;
            iterator = iterator.next;
        }
        if(size < k) return null;
        iterator = head;
        for(int i = 1; i <= size - k; i++)
            iterator = iterator.next;
        return iterator;
    }
}

//双指针大法
class Solution1 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode iteratorFirst = head;
        ListNode iteratorSecond = head;
        while(iteratorFirst != null){
            if(k == 0)  iteratorSecond = iteratorSecond.next;
            else k--;
            iteratorFirst = iteratorFirst.next;
        }
        if(k != 0)  return null;

        return iteratorSecond;
    }
}

/*合并两个有序链表*/

class Solution3 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode point1 = list1;
        ListNode point2 = list2;
        //新建一个虚拟头节点
        ListNode newHead = new ListNode(0);
        ListNode end = newHead;
        while(point1 != null && point2 != null){
            if(point1.val < point2.val){
                end.next = point1;
                point1 = point1.next;
            }
            else{
                end.next = point2;
                point2 = point2.next;
            }
            end = end.next;
        }

        if(point1 != null)  end.next = point1;
        else end.next = point2;


        return newHead.next;
    }
}