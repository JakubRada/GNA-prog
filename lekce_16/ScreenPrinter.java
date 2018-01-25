package lekce_16;

import cz.alisma.alej.prog.pg16.QuadraticEquationPrinter;

public class ScreenPrinter implements QuadraticEquationPrinter {
	  public void printEquation(int a, int b, int c, int x1, int x2) {
	    System.out.printf("%dx^2 ", a);
	    if (b >= 0) {
	    	System.out.printf("+ %dx", b);
	    }
	    if (c >= 0) {
	    	System.out.printf("+ %d", c);
	    }
	    System.out.print(" = 0\n");
	  }
	}