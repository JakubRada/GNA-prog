//package lekce_17;

import java.util.Random;

public class PolePoli {
    private static void tiskni(String jmeno, int[][] x) {
        System.out.printf("%s\n", jmeno);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.printf("%3d", x[i][j]);
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        Random rnd = new Random();
 
        int[][] matice = new int[2][2];
 
        matice[0][0] = 1;
        matice[0][1] = 2;
        matice[1][0] = 3;
        matice[1][1] = 4;
 
        tiskni("matice", matice);
 
 
        int[][] data = new int[4][];        
        for (int i = 0; i < data.length; i++) {
            data[i] = new int[i + 1];
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = rnd.nextInt(10);
            }
        }
 
        data[1][0] = -1;
 
        tiskni("data", data);
    }
}
