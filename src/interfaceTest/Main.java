package interfaceTest;

/**
 * jdk1.8之后，接口可以包含普通方法，用default修饰
 * 默认成员变量为public static final,方法为public abstract，内部类为public static
 */
public class Main {
    public static void main(String[] args) {
        Frog frog = new Frog("青蛙");
        frog.getName();
        frog.work();
        frog.swim();

        frog.behaveSwim();
    }
}

class Animal {
    String name;

    public String getName() {
        System.out.println("Animal:" + name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface IWalk {

    default void behaveWalk(){
        System.out.println("直立行走");
    }
    void work();
}

interface ISwim {
    default void behaveSwim(){
        System.out.println("水平前进");
    }
    void swim();
}

class Frog extends Animal implements IWalk, ISwim {

    public Frog(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println(this.name + ":蹦蹦跳跳地走路");
    }

    @Override
    public void swim() {
        System.out.println(this.name + ":在水里蛙泳");
    }
}
