package designPatternTest.factoryTest.factoryMethod;

import designPatternTest.factoryTest.simpleFactory.IPhoneImpl;
import designPatternTest.factoryTest.simpleFactory.Phone;

public class IphoneFactoryImpl implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new IPhoneImpl();
    }
}
