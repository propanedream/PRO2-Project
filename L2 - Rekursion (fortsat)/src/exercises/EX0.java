package exercises;

import java.util.ArrayList;


public class EX0 {


    public static int evenNumbers(ArrayList<Integer> list) {
        return evenNumbers(list, 0);
    }

    private static int evenNumbers(ArrayList<Integer> list, int index) {
        int count = 0;
        int result;
        if (index == list.size()) {
            result = 0;
        } else if (list.get(index) % 2 == 1) {
            result = list.get(index) % 2 - 1 + evenNumbers(list, index + 1);
        } else
            result = list.get(index) % 2 + 1 + evenNumbers(list, index + 1);

        return result;
    }


    public static void main(String[] args) {
        ArrayList<Integer> liste = new ArrayList<>();
        liste.add(1);
        liste.add(2);
        liste.add(3);
        liste.add(4);
        liste.add(5);
        liste.add(6);
        liste.add(7);
        liste.add(8);
        liste.add(9);
        liste.add(10);
        liste.add(11);
        liste.add(11);
        liste.add(11);
        liste.add(11);
        liste.add(12);
        System.out.println(liste);
        EX0 ex = new EX0();
        System.out.println(evenNumbers(liste));

    }
}
