import java.util.Stack;

public class MinStackTest {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(521);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(521);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();

    }
}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minValue;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minValue = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        //添加最小值记录逻辑1
        if(minValue.size() == 0 || x <= minValue.peek())
            minValue.push(x);
    }

    public void pop() {
        if(stack.pop().equals(minValue.peek()))
            minValue.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
