package lekce_14;

public class SvgGraf implements KreslicGrafu {
    double prepocet;
    int max;
    int limit;
    public SvgGraf(int max, int limit) {
        prepocet = (double) (limit) / max;
        this.max = max;
        this.limit = limit;
    }
    @Override
    public void polozka(int delka, int poradi) {
        int vyska = (int) (delka * prepocet);
        System.out.printf("<rect x=\"%d\" y=\"%d\" width=\"20\" height=\"%d\"",
                    poradi * 30 + 10, limit - vyska + 10, vyska);
        System.out.println(" fill=\"blue\" stroke=\"black\" stroke-width=\"2\"/>");
    }
}