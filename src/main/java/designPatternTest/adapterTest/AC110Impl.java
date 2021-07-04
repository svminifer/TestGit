package designPatternTest.adapterTest;

public class AC110Impl implements AC {
    public final int output = 110;

    @Override
    public int outputAC() {
        return output;
    }
}
