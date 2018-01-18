package lekce_11;

public class PoleIntu {
    int[] list = new int[0];
    int[] delsiList;
    int delka;
    //public PoleIntu() {}
    public void pridej(int a) {
        delka = list.length;
        delsiList = new int[delka + 1];
        for (int i = 0; i < delka; i += 1) {
            delsiList[i] = list[i];
        }
        delsiList[delka] = a;
        list = delsiList;
    }
    public int delka() {
        return list.length;
    }
    public int prvek(int i) {
        return list[i];
    }
}