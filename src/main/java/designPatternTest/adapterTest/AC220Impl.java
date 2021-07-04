package designPatternTest.adapterTest;

public class AC220Impl implements AC {
    public final int output=220;
    @Override
    public int outputAC() {
        return output;
    }
}
