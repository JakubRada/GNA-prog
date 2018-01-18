package lekce_3;

public class Mocniny {
    public static void main(String args[]){
        int x = Integer.parseInt(args[0]);
        for (int i = 1; i * i < x; i += 1){
            System.out.printf("%d ", i * i);
        }
    }
}