package designPatternTest.factoryTest.abstractFactory;

import designPatternTest.factoryTest.simpleFactory.IPhoneImpl;
import designPatternTest.factoryTest.simpleFactory.Phone;

public class IphoneFactoryImpl implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new IPhoneImpl();
    }

    @Override
    public PC makePC() {
        return new MacPCImpl();
    }
}
