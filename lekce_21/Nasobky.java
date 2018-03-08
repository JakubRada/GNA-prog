// package lekce_21;

import java.io.PrintWriter;
import java.io.IOException;

public class Nasobky {

	public static void main(String[] args) throws IOException {
		int cislo = 0;
		int count = 0;
		PrintWriter writer = new PrintWriter("nasobky.txt");
		for (int i = 0; i < 1000; i += 3) {
			if (count < 10) {
				writer.print(i);
				if (i < 1000 - 3) {
					writer.print(", ");
				}
				count += 1;
			} else {
				writer.println();
				count = 0;
			}
		}
		writer.close();
	}

}
