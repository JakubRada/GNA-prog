package lekce_9;

public class Otoceni2 {
    public static double[] enlarging_list(double[] old_list, int length) {
        double new_list[] = new double[length + 1];
        for (int n = 0; n < length; n += 1 ){
            new_list[n] = old_list[n];
        }
        return new_list;
    }
    public static void main(String[] args) {
        double list[] = new double[1];
        int count = 0;
        java.util.Scanner input = new java.util.Scanner(System.in);
        while (input.hasNextDouble()) {
            list[count] = input.nextDouble();
            count += 1;
            list = enlarging_list(list, count);
        }
        for (int i = count - 1; i >= 0; i -= 1) {
            System.out.printf("%.3f\n", list[i]);
        }
    }
}