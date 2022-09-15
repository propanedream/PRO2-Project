package opgave5;

import java.util.Comparator;
import java.util.TreeSet;


public class StuderendeComp implements Comparator<Studerende> {

    public static void main(String[] args) {
        TreeSet<Studerende> set = new TreeSet<>(new StuderendeComp());
    }

    @Override
    public int compare(Studerende o1, Studerende o2) {
        return o1.getNavn().compareTo(o2.getNavn());
    }
}
