package ProblemSolver;

import Utils.RandomListNode;

public class LinkedList {
    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;
        RandomListNode newHead = new Solution().Clone(head);
        while(newHead != null) {
            System.out.println(newHead.label);
            newHead = newHead.next;
        }
    }

}

class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return pHead;
        //在原链表上复制一层
        //更新next
        RandomListNode iterator = pHead;
        while(iterator != null){
            RandomListNode tmp = new RandomListNode(iterator.label);
            tmp.next = iterator.next;
            iterator.next = tmp;
            iterator = tmp.next;
        }
        //更新random
        iterator = pHead;
        while(iterator != null){
            if(iterator.random != null)
                iterator.next.random = iterator.random.next;
            iterator = iterator.next.next;
        }
        //拆分
        RandomListNode newHead = pHead.next;
        iterator = newHead;
        while(iterator != null && iterator.next != null){
            iterator.next = iterator.next.next;
            iterator = iterator.next;
            
        }
        return newHead;
    }
}
