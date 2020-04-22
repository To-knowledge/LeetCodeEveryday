package Stack1;

import java.util.ArrayList;
import java.util.Stack;

/*栈入序出序判断*/
public class Stack_1 {
    /*test*/

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{5,4,3,2,1};

        System.out.println(1);

    }

}
 class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    int min_bf = min;
    public void push(int node) {
        list.add(node);
        if(node <= min)    {
            min_bf = min;
            min = node;
        }
    }

    public void pop() {
        if(list.get(list.size() - 1) == min)
            min = min_bf;
        list.remove(list.size() - 1);

    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int min() {
        return min;
    }
}

 class Solution2 {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<Integer> minStack = new Stack<>();


     public Solution2(){
         minStack.push(Integer.MAX_VALUE);
     }

    public void push(int node) {
        list.add(node);
        if(node <= minStack.peek())    {
            minStack.push(node);
        }
    }

    public void pop() {
        if(list.get(list.size() - 1) == minStack.peek())
            minStack.pop();
        list.remove(list.size() - 1);

    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int min() {
        return minStack.peek();
    }
}