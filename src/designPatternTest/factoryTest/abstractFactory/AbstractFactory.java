package designPatternTest.factoryTest.abstractFactory;

import designPatternTest.factoryTest.simpleFactory.Phone;

public interface AbstractFactory {
    Phone makePhone();
    PC makePC();
}
