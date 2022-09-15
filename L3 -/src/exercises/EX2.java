package exercises;

import java.util.ArrayList;

public class EX2 {
    public static int zeroCount(ArrayList<Integer> list, int low, int high) {
        if (low == high) {
            return list.get(low) == 0 ? 1 : 0;
        } else {
            int middle = (low + high) / 2;
            int count1 = zeroCount(list, low, middle);
            int count2 = zeroCount(list, middle + 1, high);
            return count1+count2;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> talListe = new ArrayList<>();
        talListe.add(1);
        talListe.add(1);
        talListe.add(0);
        talListe.add(1);
        talListe.add(0);
        talListe.add(10);
        talListe.add(1);
        talListe.add(1);
        talListe.add(1);
        talListe.add(1);
        System.out.println(zeroCount(talListe, 1, 9));

    }
}
