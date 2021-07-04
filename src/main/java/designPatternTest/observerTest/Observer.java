package designPatternTest.observerTest;

/**
 * 当一个对象的改变需要同时改变其它对象，并且它不知道具体有多少对象有待改变的时候，应该考虑使用观察者模式。
 */
public abstract class Observer {
    protected String name;
    protected Subject subject;


    public Observer(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public abstract void update();
}
