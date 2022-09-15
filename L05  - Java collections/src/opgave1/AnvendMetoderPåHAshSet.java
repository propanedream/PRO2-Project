package opgave1;

import java.util.HashSet;

public class AnvendMetoderPåHAshSet {
    public static void main(String[] args) {
        //1
        HashSet<Integer> hashies = new HashSet<>();
        //2
        hashies.add(34);
        hashies.add(12);
        hashies.add(23);
        hashies.add(45);
        hashies.add(67);
        hashies.add(34);
        hashies.add(98);
        //3
        System.out.println(hashies);
        //4
        //dublicates overwriter den gamle key med ny value
        hashies.add(23);
        //5
        System.out.println(hashies);
        //6
        hashies.remove(67);
        //7
        System.out.println(hashies);
        //8
        System.out.println(hashies.contains(23));
        //9
        System.out.println(hashies.size());
    }
}
