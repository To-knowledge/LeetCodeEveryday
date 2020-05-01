public class MergeTwoOrderedLinkedList {

}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        //虚拟头节点
        ListNode newHead = new ListNode(0);
        ListNode iter = newHead;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                iter.next = p1;
                p1 = p1.next;
            }   else{
                iter.next = p2;
                p2 = p2.next;
            }
            iter =iter.next;
        }
        if(p1 != null)  iter.next = p1;
        else iter.next = p2;

        return newHead.next;
    }
}
