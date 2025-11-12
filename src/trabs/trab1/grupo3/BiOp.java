package trabs.trab1.grupo3;

public abstract class BiOp implements Exp{
    private final Exp left;
    private final Exp right;
    public final char operator;

    protected BiOp ( Exp left, Exp right, char operator){
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public int evaluate() throws InvalidExpException{
        return operate(left.evaluate(), right.evaluate());
    }

    protected abstract int operate(int v1, int v2) throws InvalidExpException;

    @Override
    public String toString() {
        String leftString = left.toString();
        String rightString = right.toString();

        if (left.getPriority() >= this.getPriority())
            leftString = "(" + left + ")";

        if (right.getPriority() >= this.getPriority())
            rightString = "(" + right + ")";

        return leftString + String.valueOf(operator) + rightString;
    }
}