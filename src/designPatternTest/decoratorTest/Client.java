package designPatternTest.decoratorTest;

public class Client {
    public static void main(String[] args) {
        //adam的换装
        Person adam = new Person("adam");

        Suits a = new Suits();
        Tie b = new Tie();
        LeatherShoes c = new LeatherShoes();

        a.Decorate(adam);
        b.Decorate(a);
        c.Decorate(b);
        c.show();

        System.out.println("\n--------------");

        //bill的换装
        Person bill = new Person("bill");

        TShirts x = new TShirts();
        Trouser y = new Trouser();
        Sneakers z = new Sneakers();

        x.Decorate(bill);
        y.Decorate(x);
        z.Decorate(y);
        z.show();
    }
}
