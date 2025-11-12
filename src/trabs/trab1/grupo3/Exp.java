package trabs.trab1.grupo3;

public interface Exp {
    int evaluate() throws InvalidExpException;
    int getPriority();
    String toString();
}