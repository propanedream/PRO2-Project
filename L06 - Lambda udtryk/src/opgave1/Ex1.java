package opgave1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1 {

    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Bent", 25), new Person("Susan", 34),
                new Person("Mikael", 60), new Person("Klaus", 44),
                new Person("Birgitte", 17), new Person("Liselotte", 9), new Person("Svende", 39));

        List<Person> persons = new ArrayList<Person>(list);

        Predicate<Person> opg1 = person-> person.getAge() == 44;
        System.out.println(findFirst(list, opg1));

        List<Person> list1 = findAll(persons, p -> p.getAge() < 30);
        System.out.println(findAll(list1, opg1));

        //opgave A
        System.out.println("opgave A");
        System.out.println(findFirst(persons, p -> p.getAge() == 44));

        //opgave B
        System.out.println("opgave B");
        System.out.println(findFirst(persons, p -> p.getName().startsWith("S")));

        //opgave C
        System.out.println("opgave C");
        System.out.println(findFirst(persons, p -> p.getName().contains("i")));

        //opgave D
        System.out.println("opgave D");
        System.out.println(findFirst(persons, p -> p.getName().length() == p.getAge()));

        //opgave F
        System.out.println("opgave F");
//        System.out.println(findAll(persons, p -> p.getName().contains("i")));
        Predicate<Person> opgaveF = person -> {
            int count = 0;
            for (int i = 0; i <person.getName().length() ; i++) {

                if (person.getName().charAt(i)==i){
                    count++;
                    System.out.println(count);
                }
            }
            return count >= 2;
        };
//                p -> p.getName().contains("i");
        System.out.println(findAll(list, opgaveF));
        //opgave G
        System.out.println("opgave G");
        System.out.println(findAll(persons, p -> p.getName().startsWith("S")));

        //opgave H
        System.out.println("opgave H");
        System.out.println(findAll(persons, p -> p.getName().length() == 5));

        //opgave I
        System.out.println("opgave I");
        System.out.println(findAll(persons, p -> p.getName().length() == 6 && p.getAge() < 40));
    }

    /**
     * Returns from the list the first person
     * that satisfies the predicate.
     * Returns null, if no person satisfies the predicate.
     */
    public static Person findFirst(List<Person> list, Predicate<Person> filter) {
        for (Person p : list) {
            if (filter.test(p))
                return p;
        }
        return null;
    }

    //opgave E
    public static List<Person> findAll(List<Person> list, Predicate<Person> filter) {
        List<Person> personList = new ArrayList<>();
        for (Person p : list) {
            if (filter.test(p))
                personList.add(p);
        }
        return personList;
    }
}
