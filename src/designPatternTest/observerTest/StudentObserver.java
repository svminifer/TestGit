package designPatternTest.observerTest;

import designPatternTest.observerTest.Observer;
import designPatternTest.observerTest.Subject;

public class StudentObserver extends Observer {

    public StudentObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    public void update() {
        System.out.println(subject.getAction()+" "+name+"开始答题。");
    }
}
