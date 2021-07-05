package designPatternTest.factoryTest.factoryMethod;

import designPatternTest.factoryTest.simpleFactory.MIPhoneImpl;
import designPatternTest.factoryTest.simpleFactory.Phone;

public class XiaoMiFactoryImpl implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new MIPhoneImpl();
    }
}
