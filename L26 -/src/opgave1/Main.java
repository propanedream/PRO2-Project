package opgave1;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Bil> hashsetbil = new HashSet<>();

        Bil b1 = new Bil("1", "honda", "civic", "rød");
        Bil b2 = new Bil("1", "honda", "civic", "rød");

        hashsetbil.add(b1);
        hashsetbil.add(b2);
        System.out.println(hashsetbil);
    }

}
