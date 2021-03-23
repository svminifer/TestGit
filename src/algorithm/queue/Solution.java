package algorithm.queue;

import java.util.Stack;

/**
 * @Author kaboso
 * @Date 2021/3/23
 */
public class Solution {

    public static boolean isValid (String s) {
        // write code here
        if(s.length() == 0) return false;

        Stack<Character> stack=new Stack();
        System.out.println(stack.empty());

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            //入栈
            if(stack.empty()){
                if(ch == '{') stack.push('}');
                if(ch == '[') stack.push(']');
                if(ch == '(') stack.push(')');
            }
            else{
                char metch=stack.peek();
                if(ch == metch) stack.pop();
                else {
                    if(ch == '{') stack.push('}');
                    if(ch == '[') stack.push(']');
                    if(ch == '(') stack.push(')');
                }
            }

        }
        return stack.empty()?true:false;


    }

    public static void main(String[] args) {
        System.out.println(isValid("[{[]}]"));
    }
}
