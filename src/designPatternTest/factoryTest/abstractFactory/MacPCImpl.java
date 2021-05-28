package designPatternTest.factoryTest.abstractFactory;

public class MacPCImpl implements PC {
    public MacPCImpl() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make iphone PC");
    }
}
