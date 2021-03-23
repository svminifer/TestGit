package api.dataStructureTest;

import java.util.Stack;

/**
 * @Author kaboso
 * @Date 2021/3/22
 */
public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();   // 返回 -3.
        minStack.pop();
        minStack.top();      //返回 0.
        minStack.min();   // 返回 -2.


    }



}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack();
        minStack=new Stack();
    }

    public void push(int x) {
        stack.push(x);
        if(!minStack.empty()){
            if(x <= minStack.peek()){//等于也可以放进去
                minStack.push(x);
            }
        }
        else{
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.peek().equals(minStack.peek()))//== 引用比较的是内存地址，基本类型比较的是值，引用类型比较内容则用equals
            minStack.pop();
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.empty()?0:minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
