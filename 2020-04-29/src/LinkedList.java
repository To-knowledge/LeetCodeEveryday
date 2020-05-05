import Utils.ListNode;

public class LinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        new Solution1().rotateRight(head, 1);

    }


}

class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        //1、拿到新的头
        ListNode NewHead;
        int i = 0;
        ListNode tmp = head;
        //1.1、计算链表长度
        int length = 0;
        ListNode tmp1 = head;
        if(tmp1 != null){
            length++;
            tmp1 = tmp1.next;
        }
        k = (k % length);
        while(i < k){
            NewHead = tmp.next;
            tmp = NewHead;
            i++;
        }
        NewHead = tmp.next;
        tmp.next = null;
        tmp = NewHead;
        while(tmp.next != null)
            tmp = tmp.next;
        //2、到末尾处将原链表前面的部分接到新链表后面
        tmp.next = head;
        return NewHead;
    }
}
