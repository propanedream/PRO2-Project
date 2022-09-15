package exercises;

import javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;

public class EX1 {
    private static int maximum(ArrayList<Integer> list, int l, int h) {
        if (l == h) {

            return list.get(l);
        } else {
            int m = (l + h) / 2;
            int max1 = maximum(list, l, m);
            int max2 = maximum(list, l + 1, h);
            if (max1 > max2) {

                return max1;


            } else
                return max2;
        }
    }


    public int maximum(ArrayList<Integer> list) {
        return maximum(list, 0, list.size() - 1);
    }

    public static int samlet(ArrayList<Integer> list, int low, int high) {
        if (low == high) {

            return list.get(high);
        } else {
            int middle = (low + high) / 2;
            int sum1 = samlet(list, low, middle);
            int sum2 = samlet(list, low + 1, high);
            return sum1 + sum2;

        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> talListe = new ArrayList<>();
        talListe.add(1);
        talListe.add(1);
        talListe.add(1);
        talListe.add(1);
        talListe.add(1);
        talListe.add(10);
        talListe.add(1);
        talListe.add(1);
        talListe.add(1);
        talListe.add(1);
        System.out.println(maximum(talListe, 0, 9));
        System.out.println(samlet(talListe,0,9));
    }
}
