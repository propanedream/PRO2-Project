package opgave5;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Skole skole = new Skole("AA");
        Studerende s1 = new Studerende(2, "Svend");
        Studerende s2 = new Studerende(1, "Alex");
        Studerende s3 = new Studerende(4, "Børge");
        Studerende s4 = new Studerende(3, "Hans");

        skole.addStuderence(s1);
        skole.addStuderence(s2);
        skole.addStuderence(s3);
        skole.addStuderence(s4);

        s1.addKarakter(7);
        s1.addKarakter(7);
        s1.addKarakter(7);

        s2.addKarakter(10);
        s2.addKarakter(10);
        s2.addKarakter(10);

        s3.addKarakter(12);
        s3.addKarakter(12);
        s3.addKarakter(12);

        s4.addKarakter(4);
        s4.addKarakter(4);
        s4.addKarakter(4);
        s4.addKarakter(4);
//
//        System.out.println(skole.getStudents());
//
//        System.out.println(skole.gennemsnit());
//
//        System.out.println(skole.findStuderende(1+2));



        TreeSet<Studerende> set1 = new TreeSet<>();
        set1.add(s1);
        set1.add(s2);
        set1.add(s3);
        set1.add(s4);

        System.out.println(set1);

        TreeSet<Studerende> set = new TreeSet<>(new StuderendeComp());
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);

        System.out.println(set);

        System.out.println(skole.getStudents());
       List<Studerende> s = skole.getStudents();

        Collections.sort(s);
        System.out.println(s);




    }
}
