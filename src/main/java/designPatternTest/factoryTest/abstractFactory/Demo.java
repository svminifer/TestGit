package designPatternTest.factoryTest.abstractFactory;

public class Demo {
    public static void main(String[] arg) {
        AbstractFactory miFactory = new XiaoMiFactoryImpl();
        AbstractFactory appleFactory = new IphoneFactoryImpl();
        miFactory.makePhone();            // make xiaomi phone!
        miFactory.makePC();                // make xiaomi PC!
        appleFactory.makePhone();        // make iphone!
        appleFactory.makePC();            // make MAC!
    }
}
