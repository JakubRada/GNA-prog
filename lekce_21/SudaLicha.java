//package lekce_21;

import java.io.IOException;
import java.io.PrintWriter;

public class SudaLicha {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int start = Integer.parseInt(args[0]);
        PrintWriter suda = new PrintWriter("suda.txt");
        for (int i = 0; i < start; i += 2) {
            suda.printf("%d ", i);
        }
        suda.close();
        PrintWriter licha = new PrintWriter("licha.txt");
        for (int i = 1; i < start; i += 2) {
            licha.printf("%d ", i);
        }
        licha.close();
    }
}