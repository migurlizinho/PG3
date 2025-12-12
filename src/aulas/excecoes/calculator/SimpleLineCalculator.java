package aulas.excecoes.calculator;


import aulas.excecoes.DivideByZeroException;

/**
 * Simple line-aulas.aula_09_11.calculator program.
 * The class can also be used to create other aulas.aula_09_11.calculator.
 */
public class SimpleLineCalculator extends PrelimCalculator {

    public void handleDivideByZeroException(DivideByZeroException e) {
        System.out.println( e.getMessage() + " - Program aborted" );
        System.exit(0);
    }

    public void handleUnknownOpException( UnknownOpException e ) {
        // This block is executed the first time UnknownOpException is.
        System.out.println( e.getMessage() );
        System.out.println( "Try again from beginning:" );
        try {
            showInicialMessage();
            doCalculation();
        } catch (UnknownOpException |
                 InvalidOperandException e2) {
            // This block catches an UnknownOpException
            // if it is thrown a second time.
            System.out.println( e.getMessage() );
            System.out.println( "Try again at some other time" );
            System.exit(0);
        } catch (DivideByZeroException e2) {
            handleDivideByZeroException( e2 );
        }
    }


    public static void main(String[] args) {
        SimpleLineCalculator clerk = new SimpleLineCalculator();
        try {
            System.out.println( "Calculator is on.");
            clerk.showInicialMessage();
            clerk.doCalculation();
        } catch (UnknownOpException e  ) {
            clerk.handleUnknownOpException( e);
        } catch (DivideByZeroException e) {
            clerk.handleDivideByZeroException( e);
        }
        catch (InvalidOperandException e) {
            System.out.println( e.getMessage() );
        }
        clerk.showFinalResult();
    }
}
