package trabs.trab1.grupo3;

public class InvalidExpException extends Exception {
    private final Exp exp;

    public InvalidExpException(Exp exp, String message) {
        super(message + " -> " + exp.toString());
        this.exp = exp;
    }
    public InvalidExpException(){
        super("Invalid expression");
        exp = null;
    }

    public Exp getExp() {
        return exp;
    }
}
