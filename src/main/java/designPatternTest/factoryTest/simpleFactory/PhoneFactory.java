package designPatternTest.factoryTest.simpleFactory;

public class PhoneFactory {
    public Phone makePhone(String phoneType){
        if (phoneType.equalsIgnoreCase("MIPhone")) {
            return new MIPhoneImpl();
        } else if (phoneType.equalsIgnoreCase("IPhone")) {
            return new IPhoneImpl();
        }
        return null;
    }
}
