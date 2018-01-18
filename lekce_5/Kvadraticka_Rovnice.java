package lekce_5;

public class Kvadraticka_Rovnice {
  public static void main(String[] args){
    double a = Double.parseDouble(args[0]);
    double b = Double.parseDouble(args[1]);
    double c = Double.parseDouble(args[2]);
    double D = (b * b) + (-4) * (a * c);
    if (D < -0.00001) {
      System.out.print("Rovnice nema koreny \n");
    } else if ((D < 0.00001) && (D > -0.00001)) {
      double x = (-b) / (2 * a);
      System.out.printf("Rovnice ma jeden koren: %f\n", x);
    } else {
      double xa = (-b + Math.sqrt(D)) / (2 * a);
      double xb = (-b - Math.sqrt(D)) / (2 * a);
      System.out.printf("Rovnice ma dva koreny: %f a %f\n", xa, xb);
    }
  }
}