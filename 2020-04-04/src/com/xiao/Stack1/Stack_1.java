package com.xiao.Stack1;

import java.util.Stack;

public class Stack_1 {

    public static void main(String[] args) {
        System.out.println(new Solution3().isValid( "[])("));
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