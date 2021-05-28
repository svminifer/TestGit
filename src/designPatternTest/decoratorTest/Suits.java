package designPatternTest.decoratorTest;


public class Suits extends Finery {
    @Override
    public void show() {
        super.show();
        System.out.println("西装");
    }
}
