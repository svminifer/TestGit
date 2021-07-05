package designPatternTest.factoryTest.factoryMethod;

public class Demo {
    public static void main(String[] arg) {
        AbstractFactory miFactory = new XiaoMiFactoryImpl();
        AbstractFactory appleFactory = new IphoneFactoryImpl();
        miFactory.makePhone();            // make xiaomi phone!
        appleFactory.makePhone();        // make iphone!
    }
}
