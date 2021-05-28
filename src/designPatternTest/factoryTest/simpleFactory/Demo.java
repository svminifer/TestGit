package designPatternTest.factoryTest.simpleFactory;

public class Demo {
    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        Phone miPhone = factory.makePhone("MiPhone");
        IPhoneImpl iPhone = (IPhoneImpl) factory.makePhone("IPhone");
        System.out.println(miPhone);
        System.out.println(iPhone);
    }
}
