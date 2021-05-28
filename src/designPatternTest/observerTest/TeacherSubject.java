package designPatternTest.observerTest;

import designPatternTest.observerTest.Observer;
import designPatternTest.observerTest.Subject;

import java.util.LinkedList;
import java.util.List;

//通知者
public class TeacherSubject implements Subject {

    private List<Observer> observers = new LinkedList<>();
    private String action;
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer o: observers) {
            o.update();
        }
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void setAction(String action) {
        this.action=action;
    }

    @Override
    public String getAction() {
        return action;
    }
}
