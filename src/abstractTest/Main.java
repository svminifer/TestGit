package abstractTest;

/**
 *  抽象类中可以包含非抽象方法，子类可以没有全部重写抽象类中的抽象方法时，则子类也一定为抽象类
 *  抽象类的成员变量跟普通类的要求相同
 *  抽象类不能被实例化
 */
public class Main {
    public static void main(String[] args) {

        Gun gun = new Gun("机关枪");
        Grenade grenade = new Grenade("手榴弹");
        gun.attack();
        grenade.attack();
        gun.how2Attack();
        grenade.how2Attack();
    }
}

abstract class Weapon {
    String name;

    public void attack() {
        System.out.println(name + "具有攻击行为");
    }

    abstract void how2Attack();

}

class Gun extends Weapon {
    public Gun(String name) {
        this.name = name;
    }

    @Override
    void how2Attack() {
        System.out.println(name + "射击敌人");
    }
}

class Grenade extends Weapon {
    public Grenade(String name) {
        this.name = name;
    }

    @Override
    void how2Attack() {
        System.out.println(name + "丢向敌人");
    }
}

