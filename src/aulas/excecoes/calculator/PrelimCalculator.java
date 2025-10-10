package aulas.excecoes.calculator;

import aulas.excecoes.DivideByZeroException;

import java.util.Scanner;

/**
 * PRELIMINARY VERSION without exception handling.
 * Simple line-oriented calculator program.
 * The class can also be used to creaye other calculator programs.
 */
public class PrelimCalculator {
	private static final double PRECISION = 0.0001;
	private double result = 0;
	public double getResult()       { return result; }
	public void setResult(double r) { result= r;     }
	public void reset()             { result= 0;     }
	public double evaluate(char op, double n1, double n2)
	         throws DivideByZeroException, UnknownOpException {
		return switch (op) {
			case '+' -> n1+n2;
			case '-' -> n1-n2;
			case '*' -> n1*n2;
			case '/' -> {
				if (-PRECISION < n2 && n2 < PRECISION)
					throw new DivideByZeroException();
				yield  n1 / n2;
			}
			default -> throw new UnknownOpException(op);
		};
	}
	public void doCalculation() throws UnknownOpException, InvalidOperandException {
		Scanner s= new Scanner(System.in);
		char nextOp= '+';
		double nextNumber = 0;
		reset();
		System.out.println("result = " + getResult());
		while( true ) {
			String line = s.nextLine().trim();
			if ( line.length() > 0 )
				try {
					nextOp = line.charAt(0);
					if (Character.toUpperCase(nextOp) == 'E')
						return;
					nextNumber = Double.parseDouble( line.substring(1) );
					setResult( evaluate (nextOp, result, nextNumber ) );
					System.out.println("result " + nextOp + ' ' +
									   nextNumber + " = " + result);
					System.out.println("update result  = " + result);
				} catch (NumberFormatException e) {
				    if (line.substring( 1 ).trim().length() > 0 )
					  throw new InvalidOperandException(line.substring(1));
				    else
				      throw new InvalidOperandException();
				}
		}
	}

	protected void showInicialMessage() {
		System.out.println( "Format of each line: operator space number");
		System.out.println( "operators: + - * /");
		System.out.println( "For example: + 3");
		System.out.println( "To end, enter the letter e.");
	}
	protected void showFinalResult() {
		System.out.println("The final result is " + getResult());
		System.out.println("Calculator program ending.");
	}

	public static void main(String[] args)
			throws UnknownOpException,
            InvalidOperandException,
            DivideByZeroException {
		PrelimCalculator clerk = new PrelimCalculator();
		System.out.println( "Calculator is on.");
		clerk.showInicialMessage();
		clerk.doCalculation();
		clerk.showFinalResult();
	}
}
