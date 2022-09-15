package opg1;

import java.util.ArrayList;
import java.util.List;

public class Opg1 {
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
        System.out.println(samlet(talListe, 0, talListe.size() - 1));
        System.out.println(sumAll(talListe, 0, talListe.size() - 1));
        System.out.println(sumAll(talListe));
    }

    //primær metode
    public static int sumAll(List<Integer> list) {
        return sumAll(list, 0, list.size()-1);
    }

    //hjælpemetode
    private static int sumAll(List<Integer> list, int nedre, int øvre) {

        //termineringsregel
        if (nedre == øvre) {
            return list.get(nedre);
        }
        int m = (nedre + øvre) / 2;
        int sum1 = sumAll(list, nedre, m);
        int sum2 = sumAll(list, m + 1, øvre);

        return sum1 + sum2;
    }


    public static int samlet(List<Integer> list, int low, int high) {
        if (low == high) {

            return list.get(high);
        } else {
            int middle = (low + high) / 2;
            int sum1 = samlet(list, low, middle);
            int sum2 = samlet(list, middle + 1, high);
            return sum1 + sum2;

        }
    }
}
