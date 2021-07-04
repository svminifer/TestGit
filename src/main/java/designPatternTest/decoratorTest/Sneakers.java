package designPatternTest.decoratorTest;

public class Sneakers extends Finery {
    @Override
    public void show() {
        super.show();
        System.out.println("运动鞋");
    }
}
