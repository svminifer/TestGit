package designPatternTest.factoryTest.simpleFactory;

public class MIPhoneImpl implements Phone {
    public MIPhoneImpl() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make xiaomi phone!");
    }
}
