package trabs.trab1.grupo3;

public class Add extends BiOp{
    private static final int PRIORITY = 6;

    protected Add(Exp left, Exp right) {
        super(left, right, '+');
    }

    @Override
    protected int operate(int v1, int v2) {
        return v1 + v2;
    }

    @Override
    public int getPriority() {
        return PRIORITY;
    }
}
