package trabs.trab1.grupo3;

public abstract class Elem implements Exp{
    protected int value;
    private final int PRIORITY = 0;

    public Elem(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public final int getPriority() {
        return PRIORITY;
    }
}