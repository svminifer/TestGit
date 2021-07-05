package designPatternTest.factoryTest.abstractFactory;

public class MIPCImpl implements PC {
    public MIPCImpl() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make xiaomi Pc");
    }
}
