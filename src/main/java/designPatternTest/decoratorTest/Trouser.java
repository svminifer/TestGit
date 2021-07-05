package designPatternTest.decoratorTest;

public class Trouser extends Finery {
    @Override
    public void show() {
        super.show();
        System.out.println("裤子");
    }
}
