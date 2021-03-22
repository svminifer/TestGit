package api.dataStructureTest;

import api.compareTest.Student;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author kaboso
 * @Date 2021/3/22
 */
public class QueueTest {
    public static void main(String[] args) {
        //LinkedList底层为双向链表，同时实现Deque接口，进而是Queue的子孙类
        LinkedList<Student> queue=new LinkedList<>();
        LinkedList<Student> linkList=new LinkedList<>();
        linkList.addFirst(null);
        linkList.addLast(null);
        linkList.removeFirst();
        linkList.removeLast();

        for (int i = 0; i < 10; i++) {
            Student student=new Student("王"+i,i%2==0?"男":"女",i+20);
            queue.offer(student);//入队
        }

        //查看队列头
        Student peek = queue.peek();
        System.out.println(peek);
        //出队，删除队列头
        Student poll = queue.poll();
        System.out.println(poll);

        //剩余
        int size = queue.size();
        System.out.println(size);

//      如果：queue的引用类型为 Queue<Student> queue
//      则使用queue.get(1);由于多态的特性，会导致编译错误，
// 这时候必须将改为LinkedList<Student> queue。因为Queue接口没有get方法，但LinkedList有


    }
}
