package designPatternTest.decoratorTest;

public class TShirts extends Finery {
    @Override
    public void show() {
        super.show();
        System.out.println("T恤");
    }
}
