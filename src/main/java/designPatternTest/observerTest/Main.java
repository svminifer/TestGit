package designPatternTest.observerTest;

/**
 * 场景：老师将所有要考试的同学都叫过来，然后到点准备告诉他们开始考试
 *
 * Subject  相当于 主题--> 作为一个发布者
 * Observer 相当于 观察者--> 作为一个订阅者
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        TeacherSubject teacher = new TeacherSubject();

        StudentObserver zhangsan = new StudentObserver("张三", teacher);
        StudentObserver lisi = new StudentObserver("李四", teacher);
        StudentObserver wangwu = new StudentObserver("王五", teacher);

        //老师叫张三、李四、王五都过来考试
        teacher.attach(zhangsan);
        teacher.attach(lisi);
        teacher.attach(wangwu);

        teacher.setAction("同学们开始考试了！");

        teacher.notifyObserver();//通知所有同学




    }
}
