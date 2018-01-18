package lekce_13;

public class Cetnost {
    String[] list = new String[0];
    int[] cetnosti = new int[0];
    public Cetnost() {}
    public int[] zvetsiInt(int[] oldList) {
        int[] newList = new int[oldList.length + 1];
        for (int i = 0; i < oldList.length; i += 1) {
            newList[i] = oldList[i];
        }
        return newList;
    }
    public String[] zvetsiString(String[] oldList) {
        String[] newList = new String[oldList.length + 1];
        for (int i = 0; i < oldList.length; i += 1) {
            newList[i] = oldList[i];
        }
        return newList;
    }
    public int index(String slovo) {
        for (int i = 0; i < list.length; i += 1) {
            if (list[i].equals(slovo)) {
                return i;
            }
        }
        return -1;
    }
    public void zapocitej(String slovo) {
        int umisteni = index(slovo);
        if (umisteni != -1) {
            cetnosti[umisteni] += 1;
        } else {
            list = zvetsiString(list);
            cetnosti = zvetsiInt(cetnosti);
            list[list.length - 1] = slovo;
            cetnosti[cetnosti.length - 1] = 1;
        }
    }
    public void tisk() {
        for (int i = 0; i < list.length; i += 1) {
            System.out.printf("%s ... %dkrat\n", list[i], cetnosti[i]);
        }
    }
}