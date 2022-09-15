package opg2;

import java.util.ArrayList;
import java.util.List;

public class Opg2 {
    public static void main(String[] args) {
        ArrayList<Integer> talliste = new ArrayList<>();

        talliste.add(0);
        talliste.add(2);
        talliste.add(0);
        talliste.add(0);
        talliste.add(0);
        talliste.add(2);
        talliste.add(0);
        System.out.println(antalNul(talliste));
    }

    public static int antalNul(List<Integer> liste) {
        return antalNul(liste, 0, liste.size() - 1);
    }

    private static int antalNul(List<Integer> liste, int low, int high) {
        if (low == high) {
            if (liste.get(low) == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int middle = (low + high) / 2;
        int sum1 = antalNul(liste, low, middle);
        int sum2 = antalNul(liste, middle+1, high);
        return sum1 + sum2;
    }
}
