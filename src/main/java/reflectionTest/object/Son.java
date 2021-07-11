package reflectionTest.object;

@Value(sex = TypeEnum.GIRL)
public class Son extends Father implements Speak {

    @Value(sex = TypeEnum.GIRL)
    public void play() {
        System.out.println(this.getClass().getSimpleName() + " like playing");
    }

}
