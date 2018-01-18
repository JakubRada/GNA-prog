package pololetni_prace_1;

import java.io.IOException;
import java.io.PrintWriter;

public class Graf {
	public static void createFile(int[] list, int pocet, int max) {
		int sirka = 20;
		int vyska = max + 10;
		String height = Integer.toString(vyska);
		String width = Integer.toString((sirka + 5) * (pocet + 1));
		String viewBox = String.format("0 0 %s %s", width, height);
		try{
			PrintWriter writer = new PrintWriter("Graf.svg", "UTF-8");
			writer.println("<?xml version=\"1.0\"?>");
			writer.println(String.format("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"%s\" height=\"%s\" viewBox=\"%s\">", width, height, viewBox));
			for (int i = 0; i < pocet; i += 1) {
				writer.println(String.format("<rect x=\"%s\" y=\"%s\" width=\"%s\" height=\"%s\" fill=\"red\" stroke=\"black\" strok-width=\"2\"/>", (sirka + 5) * i + 10, vyska - list[i], Integer.toString(sirka), list[i]));
			}
			writer.println("</svg>");
			writer.close();
		} catch (IOException e) {}
	}
	public static void main(String[] args) {
		System.out.println("Zadejte maximalne 100 kladnych cisel: ");
		int cisla[] = new int[100];
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int pocet = 0;
		int input = 0;
		int max = 0;
		while (sc.hasNextInt() && (pocet < cisla.length)) {
			input = sc.nextInt();
			if (input > 0) {
				cisla[pocet] = input;
				pocet += 1;
			}
			if (input > max) {
				max = input;
			}
		}
		createFile(cisla, pocet, max);
	}
}
