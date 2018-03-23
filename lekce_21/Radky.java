import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Radky {
    public static String nejRadek(String file) {
        String line;
        String longestLine = "";
        try {
            FileReader reader = new FileReader(file + ".txt");
            Scanner sc = new Scanner(reader);
            while (sc.hasNext()) {
                line = sc.nextLine();
                if (line.length() > longestLine.length()) {
                    longestLine = line;
                }
            }
            reader.close();
            return longestLine;
        } catch(IOException ex) {
            System.out.printf("Soubor %s neexistuje\n", file);
            return "";
        }
    }

    public static void main(String[] args) {
        String[] soubory = new String[args.length];
        for (int i = 0; i < args.length; i += 1) {
            soubory[i] = args[i];
        }
        String nejdelsiRadek = "";
        int nejdelsiSoubor = -1;
        String radekZeSouboru;
        for (int i = 0; i < soubory.length; i += 1) {
            radekZeSouboru = nejRadek(soubory[i]);
            if (radekZeSouboru.length() > nejdelsiRadek.length()) {
                nejdelsiRadek = radekZeSouboru;
                nejdelsiSoubor = i;
            }
        }
        System.out.printf("Nejdelsi je rade ze souboru %s\n\'%s\'", soubory[nejdelsiSoubor] , nejdelsiRadek);
    }
}
