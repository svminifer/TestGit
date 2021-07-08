package objectTest;

import java.util.Collections;
import java.util.HashMap;

/**
 * 向上转型和向下转型
 * @Author kaboso
 * @Date 2021/4/1
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Fruit apple = new Apple();


        Fruit fruit = new Apple();
        Apple applea = (Apple) fruit;

        Class<?> name = Class.forName("objectTest.Fruit");

        Object o = name.newInstance();

        System.out.println(o instanceof Fruit);
    }
}

class Fruit{

    private String name;

    public Fruit() {
        System.out.println("Fruit");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("Fruit");
    }
}
class Apple extends Fruit{
    private String type;

    public Apple(){
        System.out.println("apple");
    }
    public String getType() {
        return type;
    }

    public void eat(){
        System.out.println("apple eat");
    }

    public void setType(String type) {
        this.type = type;
    }
}

