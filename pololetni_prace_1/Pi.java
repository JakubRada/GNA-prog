package pololetni_prace_1;

public class Pi {
    public static int obsah_kruhu(int polomer) {
        int obsah = 0;
        for (int y = -polomer; y <= polomer; y += 1) {
            for (int x = -polomer; x <= polomer; x += 1) {
                if ((x * x + y * y) <= polomer * polomer) {
                    obsah += 1;
                }
            }
        }
        return obsah;
    }
    public static double vzorec(int obsahKruhu, int obsahCtverce) {
        /**
        S[kruhu] / S[ctverce] = (pi * d^2 / 4) / d^2 = pi / 4    =>   pi = 4 * (S[kruhu] / S[ctverce])
         */
        return 4 * ((double)obsahKruhu / obsahCtverce);
    }
    public static void main(String[] args) {
        int polomer = 23000;
        int kruh = obsah_kruhu(polomer);
        int ctverec = (2 * polomer + 1) * (2 * polomer + 1);
        double Ludolfovo_cislo = vzorec(kruh, ctverec);
        System.out.printf("Ludolfovo cislo je %.4f.\n", Ludolfovo_cislo);
    }
}