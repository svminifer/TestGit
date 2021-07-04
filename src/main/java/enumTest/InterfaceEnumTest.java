package enumTest;

interface Food {
    enum CoffeeEnum implements Food{
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
    }
    enum DessertEnum implements Food{
        FRUIT, CAKE, GELATO
    }
}

public class InterfaceEnumTest {
    private static void testImplementsInterface() {
        for (Food.DessertEnum dessertEnum : Food.DessertEnum.values()) {
            System.out.print(dessertEnum + "  ");
        }
        System.out.println();
        //我这地方这么写，是因为我在自己测试的时候，把这个coffee单独到一个文件去实现那个food接口，而不是在那个接口的内部。
        for (Food.CoffeeEnum coffee : Food.CoffeeEnum.values()) {
            System.out.print(coffee + "  ");
        }
        System.out.println();
        //搞个实现接口，来组织枚举，简单讲，就是分类吧。如果大量使用枚举的话，这么干，在写代码的时候，就很方便调用啦。
        //还有就是个“多态”的功能吧，
        Food food = Food.DessertEnum.CAKE;
        System.out.println(food);
        food = Food.CoffeeEnum.BLACK_COFFEE;
        System.out.println(food);
    }

    public static void main(String[] args) {
        testImplementsInterface();
    }
}
