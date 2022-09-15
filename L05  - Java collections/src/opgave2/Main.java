package opgave2;

public class Main {
    public static void main(String[] args) {
        Skole skole = new Skole("AA");
        Studerende s1 = new Studerende(1, "Svend1");
        Studerende s2 = new Studerende(2, "Svend2");
        Studerende s3 = new Studerende(3, "Svend3");
        Studerende s4 = new Studerende(4, "Svend4");

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
        s3.addKarakter(100);
        s3.addKarakter(12);

        s4.addKarakter(4);
        s4.addKarakter(4);
        s4.addKarakter(12);
//        s4.addKarakter(4);

        System.out.println(skole.getStudents());

        System.out.println(skole.gennemsnit1());

//        System.out.println(skole.findStuderende(1+2));


    }
}
