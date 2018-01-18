package lekce_13;

import java.io.IOException;
import java.util.Scanner;

public class CetnostSlov {
    public static void main(String[] args) throws IOException {
        String slovo = "";
        Scanner sc = new Scanner(System.in);
        Cetnost seznam = new Cetnost();
        while (true) {
            int znak = System.in.read();
            if (znak == -1) {
                break;
            }
            char pismeno = (char) znak;
            if (pismeno == ' ') {
                seznam.zapocitej(slovo);
                slovo = "";
            } else {
                slovo = slovo + pismeno;
            }
        }
        System.out.println("Seznam slov s cetnostmi: ");
        seznam.tisk();
    }
}