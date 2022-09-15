package Eks;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class FletteSorteringHul {

    // den metode der saetter fletningen i gang
    public void fletteSort(ArrayList<Integer> list) {
        mergesort(list, 0, list.size());
    }

    // den rekursive metode der implementere del-loes og kombiner skabelonen
    private void mergesort(ArrayList<Integer> list, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            mergesort(list, l, m);
            mergesort(list, m + 1, h);
            merge(list, l, m, h);

        }
    }

    // kombiner er realiseret ved fletteskabelonen
    private void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        // TODO


        int m = middle;


        while (low < middle && m < high) {
            if (list.get(low).compareTo(list.get(m)) <=0) {
                temp.add(list.get(low));
                low++;
            } else {
                temp.add(list.get(m));
                m++;
            }
        }

        while (low < middle) {
            temp.add(list.get(low));
            low++;
        }
        while (m < high) {
            temp.add(list.get(m));
            m++;
        }

        for (int k = 0; k < temp.size() ; k++) {
            list.set(k, temp.get(k));
        }

    }

    //result = den tomme sekvens
    //while (der er elementer i s1 && der er elementer i s2) {
    //    e1 = det element man er kommet til i s1
    //    e2 = det element man er kommet til i s2
    //    if (e1 <= e2) {
    //        tilføj e1 bagest i resultat
    //        gå videre i s1
    //    } else {
    //        tilføj e2 bagest i resultat
    //        gå videre i s2
    //    }
    //}
    //
    //while (der er elementer i s1) {
    //    tilføj det element man er kommet til i s1 til resultat
    //    gå videre i s1
    //}
    //while (der er elementer i s2) {
    //    tilføj det element man er kommet til i s2 til resultat
    //    gå videre i s2
    //}
    //
    //return result;


//    int e1 = list.get(low);
//    int e2 = list.get(middle);
//    int m = middle;
//        while (m > low && middle != high) {
//
//        if (e1 <= e2) {
//            temp.add(e1);
//            low++;
//        } else {
//            temp.add(e2);
//            middle++;
//        }
//    }
//        while (m > low) {
//        temp.add(e1);
//        low++;
//    }
//        while (middle != high) {
//        temp.add(e2);
//        middle++;
//    }
//        System.out.println("1" + temp);

}
