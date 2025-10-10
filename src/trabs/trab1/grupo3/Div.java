package trabs.trab1.grupo3;

public class Div extends BiOp{
    private final int PRIORITY = 5;

    protected Div(Exp left, Exp right) {
        super(left, right, '/');
    }

    @Override
    protected int operate(int v1, int v2) throws InvalidExpException {
        if(v2 == 0){
            if(v1 == 0)
                throw new InvalidExpException(this, "Indeterminate");
            else
                throw new InvalidExpException(this, "Divide by zero");
        }
        return v1 / v2;
    }

    @Override
    public int getPriority() {
        return PRIORITY;
    }
}