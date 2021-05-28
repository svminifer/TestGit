package designPatternTest.decoratorTest;

public class Tie extends Finery {
    @Override
    public void show() {
        super.show();
        System.out.println("领带");
    }
}
