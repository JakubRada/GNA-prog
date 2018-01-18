package lekce_6;

public class Nasobeni {
  public static void main(String[] args) {
    int x = Integer.parseInt(args[0]);
    int y = Integer.parseInt(args[1]);
    int result = x * y;
    int lenght_x = 0;
    int lenght_y = 0;
    int lenght_result = 0;
    int lenght_step = 0;
    int indent = 5; // o kolik bude vysledek odsazeny z leva, ostatni cisla jsou zarovnana podle vysledku
    int step = 0; // ukladani mezivypoctu
    int line = 0; // kolikaty radek to je(kvuli odsazovani mezivypoctu)
    for (int n = result; n >= 1; n /= 10) {lenght_result += 1;}
    for (int n = x; n >= 1; n /= 10) {lenght_x += 1;}
    for (int n = y; n >= 1; n /= 10) {lenght_y += 1;}
    for (int n = lenght_result + indent - lenght_x; n > 0; n -= 1){
      System.out.print(" ");
    }
    System.out.println(x);
    System.out.print("*");
    for (int n = lenght_result + (indent - 1) - lenght_y; n > 0; n -= 1){
      System.out.print(" ");
    }
    System.out.println(y);
    for (int n = lenght_result + indent; n > 0; n -= 1){
      System.out.print("-");
    }
    System.out.print("\n");
    while (y > 0) {
      lenght_step = 0;
      step = x * (y % 10);
      for (int n = step; n >= 1; n /= 10) {
        lenght_step += 1;
      }
      for (int n = lenght_result - lenght_step - line + indent; n > 0; n -= 1) {
        System.out.print(" ");
      }
      System.out.printf("%d\n", step);
      y /= 10;
      line += 1;     
    }
    for (int n = lenght_result + indent; n > 0; n -= 1){
      System.out.print("-");
    }
    System.out.print('\n');
    for (int n = indent; n > 0; n -= 1) {
      System.out.print(" ");
    }
    System.out.println(result);       
  }
}
