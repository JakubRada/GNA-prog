package lekce_14;

public class ObrazovkovyGraf implements KreslicGrafu {
    double prepocet;
    public ObrazovkovyGraf(int max, int limit){
        prepocet = (double) (limit) / max;
    }
    @Override
    public void polozka(int delka, int poradi) {
        for (int i = 0; i < (int) (delka * prepocet); i += 1) {
            System.out.print("#");
        }
        System.out.println();
    }
}