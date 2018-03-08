//package lekce_21;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MinMax {
	public static void main(String[] args) throws IOException{
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int num;
		FileReader reader = new FileReader("cisla.txt");
		Scanner sc = new Scanner(reader);
		while (sc.hasNextInt()){
			num = sc.nextInt();
			if (num > max) {
				max = num;
			} else if (num < min) {
				min = num;
			}
		}
		sc.close();
		reader.close();
		System.out.printf("Minimum ... %d\nMaximum ... %d", min, max);
	}
}
