package reflectionTest.object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@HasInherited
public class Father extends Human implements Speak, Work {
    private String name;
    private int sex;

    @Override
    public void canSpeak() {
        System.out.println(this.getClass().getSimpleName() + " can speak");
    }

    @Override
    public void canWork() {
        System.out.println(this.getClass().getSimpleName() + " can work");
    }

    @Value()
    private void hobby(String hobbyName) {
        System.out.println(this.getClass().getSimpleName() + " has special hobby - " + hobbyName);
    }
}
