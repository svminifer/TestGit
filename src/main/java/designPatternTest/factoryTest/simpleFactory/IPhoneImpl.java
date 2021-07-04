package designPatternTest.factoryTest.simpleFactory;

public class IPhoneImpl implements Phone {
    public IPhoneImpl() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make iphone!");
    }
}
