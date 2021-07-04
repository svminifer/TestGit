package api.compareTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author kaboso
 * @Date 2021/3/21
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student=new Student("王"+i,i%2==0?"男":"女",i+20);
            students.add(student);
        }



        Collections.shuffle(students);

        for (int i = 0; i < students.size(); i++) {
            Student student =  students.get(i);
            System.out.println(student);
        }

        Collections.sort(students);//自动调用重写的compareTo()

        System.out.println();
        for (int i = 0; i < students.size(); i++) {
            Student student =  students.get(i);
            System.out.println(student);
        }
        System.out.println();

        Collections.sort(students, Comparator.comparingInt(o -> o.getSex().getBytes().length));
        for (int i = 0; i < students.size(); i++) {
            Student student =  students.get(i);
            System.out.println(student);
        }
    }
}
