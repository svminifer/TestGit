package api.dataStructureTest;

import api.compareTest.Student;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 栈练习
 * @Author kaboso
 * @Date 2021/3/22
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Student> stack=new Stack<>();

        for (int i = 0; i < 10; i++) {
            Student student=new Student("王"+i,i%2==0?"男":"女",i+20);
            stack.push(student);//压入栈中
        }

//        只查看栈顶的元素，不弹出
        Student peek = stack.peek();
        System.out.println(peek);
//        弹出当前栈顶的元素
        Student pop = stack.pop();
        System.out.println(pop);

//        因为Stack继承了Vector类，所以可以使用父类的方法
//        获取第二个压入的元素
        Student student = stack.get(2);
        int size = stack.size();
        System.out.println(size);


        //LinkedList即可以模拟队列，也可以模拟栈
        LinkedList<Student> linkList=new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Student students=new Student("王"+i,i%2==0?"男":"女",i+20);
            linkList.push(students);//入队
        }
        Student linkPop = linkList.pop();
        System.out.println(linkPop);


    }
}
