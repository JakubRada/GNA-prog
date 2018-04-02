import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Email {
	public static String[] nactiDataZeSouboru(String jmeno) throws IOException {
		FileReader reader = new FileReader(jmeno);
		Scanner sc = new Scanner(reader);
		ArrayList <String> radky = new ArrayList<String>();
		while (sc.hasNextLine()) {
			radky.add(sc.nextLine());
		}
		//String[] lines = radky.toArray(lines);
		String[] lines = new String[radky.size()];
		lines = radky.toArray(lines);
		return lines;
	}

	public static String[] ziskejOdesPredm(String jmeno) throws IOException {
		String[] radky = nactiDataZeSouboru(jmeno);
		String[] a;
		int zacatek = 0;
		int konec = 0;
		String radek;
		String[] vysledek = new String[] {"", ""};
		for (int i = 0; i < radky.length; i += 1) {
			radek = radky[i];
			try {
				a = radek.split(":");
				if (a[0].equals("From")) {
					zacatek = i;
				} else if (a[0].equals("To")) {
					konec = i;
					break;
				}
			} catch(Exception x) {
				continue;
			}
		}
		vysledek[0] = radky[zacatek].substring(6);
		for (int i = zacatek + 1; i < konec; i += 1) {
			if (i == zacatek + 1) {
				vysledek[1] += radky[i].substring(9);
			} else {
				vysledek[1] += radky[i];
			}
		}
		return vysledek;

	}

	public static void tiskInformaci(String jmeno) throws IOException {
		String[] data = ziskejOdesPredm(jmeno);
		System.out.printf("Odesilatel: \n\t%s\n", data[0]);
		System.out.printf("Subject: \n\t%s\n", data[1]);
	}

	public static void main(String[] args) throws IOException {
		for (String jmeno: args) {
			tiskInformaci(jmeno);
		}
	}
}