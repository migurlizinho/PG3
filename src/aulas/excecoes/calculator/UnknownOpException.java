package aulas.excecoes.calculator;

public class UnknownOpException extends Exception {
	public UnknownOpException() {
		super("unknown operator exception");
	}
	public UnknownOpException(char op) {
		super(op + " is an unknown operator.");
	}
	public UnknownOpException(String msg) {
		super( msg );
	}
}
