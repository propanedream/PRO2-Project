package opg3;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(20, "Ahmed1");
        Person p2 = new Person(20, "Ahmed2");
        Person p3 = new Person(20, "Ahmed3");
        Person p4 = new Person(20, "Ahmed4");
        Person p5 = new Person(20, "Ahmed5");


        PersonAdministrator p = PersonAdministrator.getInstance();
        p.setNavn("Admins");


        p.addperson(p1);
        p.addperson(p2);
        p.addperson(p3);
        p.addperson(p4);
        p.addperson(p5);

        System.out.println(p.getPersoner());
    }
}
