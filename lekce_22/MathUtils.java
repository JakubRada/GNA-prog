package lekce_22;

public class MathUtils {
    public static int min(int... numbers) {
    	if (numbers.length == 0) {
    		throw new IllegalArgumentException("Nebylo zadano cislo");
    	}
    	int minimum = Integer.MAX_VALUE;
        for (Integer n: numbers) {
        	if (n < minimum) {
        		minimum = n;
        	}
        }
        return minimum;
    }
    public static int gcd2(int a, int b) {
    	
    }
}
