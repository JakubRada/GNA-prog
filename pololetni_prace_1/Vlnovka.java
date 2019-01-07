package pololetni_prace_1;

public class Vlnovka {
    public static void main(String[] args){
        int vyska = Integer.parseInt(args[0]);
        int delka = 80;
        int aktualni_delka = 0;
        int delka_periody = vyska * 2 - 2;
        if (delka_periody <= delka) {
            for (int i = 0; i < vyska; i += 1) {
                aktualni_delka = delka_periody;
                while (aktualni_delka <= delka) {
                    for (int n = 0; n < i; n += 1) {
                        System.out.print(" ");
                    }
                    System.out.print("#");
                    if (i == 0) {
                        for (int n = 0; n < delka_periody - 1; n += 1) {
                            System.out.print(" ");
                        }
                    } else {
                        for (int n = 0; n < (delka_periody - i - 2 - (i - 1)); n += 1) {
                            System.out.print(" ");
                        }
                        if (i != vyska - 1) {
                            System.out.print("#");
                        }
                        for (int n = 0; n < i - 1; n += 1) {
                            System.out.print(" ");
                        }
                    }
                    aktualni_delka += delka_periody;
                }
                if (i == 0) {
                    System.out.print("#");
                }
                System.out.println();
            }
        } else {
            System.out.println("Zadana vyska je moc velka");
        }
    }
}