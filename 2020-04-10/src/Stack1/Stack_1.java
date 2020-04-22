package Stack1;

import java.util.Stack;

public class Stack_1 {

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,5,3,2,1};


        System.out.println(new Solution5().IsPopOrder(arr1, arr2));
    }

}

class Solution {
   public boolean isValid(String s) {
       if(s == null || s.length() == 0 ) return true;
       Stack<Character> stack = new Stack<>();
       stack.push(s.charAt(0));
       for(int i = 1; i < s.length(); i++){
           if(stack.size() == 0){
               stack.push(s.charAt(i));
               continue;
           }
           if(s.charAt(i) == ')' && stack.peek() == '('){
               stack.pop();
           }
           else if(s.charAt(i) == '}' && stack.peek() == '{'){
               stack.pop();
           }
           else if(s.charAt(i) == ']' && stack.peek() == '['){
               stack.pop();
           }
           else{
               stack.push(s.charAt(i));
           }
       }

       if(stack.size() == 0)
           return true;

       return false;

   }
}
class Solution2 {
    public boolean isValid(String s) {
        if(s == null) return true;
        char[] stack = new char[s.length()];
        int size = 0;
        for(int i = 0; i < s.length(); i++){
            if(size == 0){
                stack[size++] = s.charAt(i);
                continue;
            }
            if(s.charAt(i) == ')' && stack[size - 1] == '('){
                size--;
            }
            else if(s.charAt(i) == '}' && stack[size - 1] == '{'){
                size--;
            }
            else if(s.charAt(i) == ']' && stack[size - 1] == '['){
                size--;
            }
            else{
                stack[size++] = s.charAt(i);
            }
        }

        if(size == 0)
            return true;

        return false;

    }
}

class Solution3 {
    public boolean isValid(String s) {
        if(s == null) return true;
        if(s.length() % 2 == 1) return false;
        char[] stack = new char[s.length() / 2];
        int size = 0;
        for(int i = 0; i < s.length(); i++){

            try {
                if (size == 0) {
                    stack[size++] = s.charAt(i);
                    continue;
                }
                if (s.charAt(i) == ')' && stack[size - 1] == '(') {
                    size--;
                } else if (s.charAt(i) == '}' && stack[size - 1] == '{') {
                    size--;
                } else if (s.charAt(i) == ']' && stack[size - 1] == '[') {
                    size--;
                } else {
                    stack[size++] = s.charAt(i);
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                return false;
            }
        }

        if(size == 0)
            return true;

        return false;

    }
}

class Solution5 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int p1 = 0;
        int p2 = 0;
        if(pushA == null || pushA.length == 0)    return true;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[p1++]);
        while(p1 <= pushA.length){
            if(stack.size() != 0 && stack.peek() == popA[p2]){
                p2++;
                stack.pop();
            }
            else{
                if(p1 == pushA.length)
                    p1++;
                else
                    stack.push(pushA[p1++]);
            }
        }
        if(p2 == popA.length)    return true;
        return false;
    }
}