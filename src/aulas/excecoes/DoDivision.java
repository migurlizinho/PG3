package aulas.excecoes;

import java.util.Scanner;

public class DoDivision {
    private int numerator;
    private int denominator;
    private double quotient;

    public static void main(String[] args) {
        DoDivision doIt = new DoDivision();
        try {
            doIt.normal();
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
            doIt.secondChance();
        }
        System.out.println("End of program.");
    }

    public void normal() throws DivideByZeroException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter numerator:");
        numerator = keyboard.nextInt();
        System.out.println("Enter denominator:");
        denominator = keyboard.nextInt();
        if (denominator == 0) {
            throw new DivideByZeroException();
        }
        quotient = numerator / (double)denominator;
        System.out.println(numerator + " / " + denominator + " = " + quotient);
    }

    public void secondChance() {
        System.out.println("Try again.");
        System.out.println("Be sure the denominator is not zero.");
        try {
            normal();
        } catch (DivideByZeroException e) {
            System.out.println("I cannot do division by zero.");
            System.out.println("Since I cannot do you want.");
            System.out.println("The program will now end.");
            System.exit(0);
        }
    }
}
