package lekce_16;

import cz.alisma.alej.prog.pg16.QuadraticEquationGenerator;
import cz.alisma.alej.prog.pg16.QuadraticEquationPrinter;

public class Rovnice {
    public static void main(String[] args) {
    	int x = Integer.parseInt(args[0]);
    	if (x == 0) {
    		// QuadraticEquationPrinter printer = new HtmlPrinter();
    	} else {
    		QuadraticEquationPrinter printer = new ScreenPrinter();
    	}
  
    	
        QuadraticEquationGenerator.generate(10, printer);
        
    }
}