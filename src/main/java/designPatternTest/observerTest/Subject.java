package designPatternTest.observerTest;

import java.util.LinkedList;
import java.util.List;

public interface Subject {
    //增加
    void attach(Observer observer);

    //通知
    void notifyObserver();

    //删除
    void remove(Observer observer);

    //状态
    void setAction(String action);

    String getAction();
}
