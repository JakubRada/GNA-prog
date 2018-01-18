package lekce_9;

public class Otoceni1 {
    public static void main(String[] args) {
        double numbers[] = new double[100];
        java.util.Scanner input = new java.util.Scanner(System.in);
        int count = 0;
        while (input.hasNextDouble()) {
            numbers[count] = input.nextDouble();
            count += 1;
            if (count == numbers.length){
              break;
            }
        }
        for (int i = count - 1; i >= 0; i -=1){
            System.out.printf("%.3f\n", numbers[i]);
        }
        System.out.println();
    }
}