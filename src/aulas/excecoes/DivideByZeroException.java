package aulas.excecoes;

public class DivideByZeroException extends RuntimeException {
	public DivideByZeroException() {
		super("Divide by zero");
	}
	public DivideByZeroException(String msg) {
		super( msg );
	}
}
