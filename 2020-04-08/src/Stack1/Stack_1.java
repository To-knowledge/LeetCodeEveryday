package Stack1;

import java.util.Stack;
/*栈入序出序判断*/
public class Stack_1 {
    /*test*/

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{5,4,3,2,1};

        System.out.println(new Solution().validateStackSequences(arr1, arr2));

    }

}


class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0)  return true;
        Stack<Integer> stack =  new Stack<>();
        //stack.push(pushed[0]);
        int p1 = 0;
        int p2 = 0;
        //条件一定是小于等于
        while(p1 <= pushed.length){
            if(stack.size() != 0 && stack.peek() == popped[p2]){
                p2++;
                stack.pop();
            }
            else{
                if(p1 == pushed.length)
                    p1++;
                else
                    stack.push(pushed[p1++]);
            }
        }

        if(p2 == popped.length) return true;
        else return false;

    }
}
