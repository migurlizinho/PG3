package trabs.trab1.grupo2;

public class GradeException extends Exception {
    public GradeException(String message) {
        super(message);
    }
    public GradeException(){
        super("classificacao invalida");
    }
}