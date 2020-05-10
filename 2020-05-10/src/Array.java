import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Array {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        new Solution().buildArray(arr,3);
    }

}


class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> result = new ArrayList<>();
        //先将n个数入栈
        Stack<Integer> stack = new Stack<>();
        for(int i = n; i > 0; i--)
            stack.push(i);
        //遍历数组target
        int i = 0;
        while(i < target.length){
            if(stack.pop() == target[i]){
                result.add("Push");
                i++;
            }else{
                result.add("Push");
                result.add("Pop");
            }
        }

        return result;
    }
}