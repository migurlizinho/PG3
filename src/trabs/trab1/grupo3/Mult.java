package trabs.trab1.grupo3;

public class Mult extends BiOp{
    private static final int PRIORITY = 5;

    protected Mult(Exp left, Exp right) {
        super(left, right, '*');
    }

    @Override
    protected int operate(int v1, int v2) {
        return v1 * v2;
    }

    @Override
    public int getPriority() {
        return PRIORITY;
    }
}
