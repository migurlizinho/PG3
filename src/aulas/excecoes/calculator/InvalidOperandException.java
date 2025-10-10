package aulas.excecoes.calculator;

public class InvalidOperandException extends Exception {
	public InvalidOperandException() {
		super("Invalid operand");
	}
	public InvalidOperandException( String op ) {
		super( op + " - it is not a double");
	}
}
