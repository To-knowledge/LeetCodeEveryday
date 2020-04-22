package xiao.Heap2;

import Util.ListNode;

public class Heap2 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        //lists[2].next.next = new ListNode(5);
        new Solution().mergeKLists(lists);


    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head;
        ListNode[] smallHeap = new ListNode[lists.length];
        int size = 0;
        ListNode tmp;
        ListNode tmp1;
        int index;
        //建堆
        for(int i = 0; i < lists.length; i++){
            if (lists[i] == null)   continue;
            size++;
            smallHeap[size - 1] = lists[i];
            //siftUp
            index = size - 1;
            while(index > 0){
                if(smallHeap[index].val < smallHeap[(index - 1) >> 1].val){
                    tmp = smallHeap[index];
                    smallHeap[index] = smallHeap[(index-1) >> 1];
                    smallHeap[(index-1) >> 1] = tmp;
                    index = (index - 1) >> 1;
                }else{
                    break;
                }
            }
        }
        //出堆,虚拟头节点
        head = new ListNode(0);
        tmp = head;
        int child;
        while(size > 0){
            //取出堆顶链表头元素
            tmp.next = smallHeap[0];
            tmp = tmp.next;

            smallHeap[0] = smallHeap[0].next;
            //siftDown
            if(smallHeap[0] == null){
                smallHeap[0] = smallHeap[size - 1];
                size--;
            }
            index = 0;
            //非叶子节点，叶子节点编号最小的是size >> 1
            while(index < (size >> 1)){
                //找出左右子节点中最小的索引,默认选择左子节点
                child = (index << 1) + 1;
                if(child + 1 < size)
                    child = smallHeap[child + 1].val > smallHeap[child].val ? child : child + 1;
                //选择是否交换
                if (smallHeap[index].val > smallHeap[child].val){
                    tmp1 = smallHeap[index];
                    smallHeap[index] = smallHeap[child];
                    smallHeap[child] = tmp1;
                    index = child;
                }else
                    break;
            }
        }



        return head.next;
    }
}



