package opgave2;

public class Opgave2 {
    public static void main(String[] args) {

      Counter c = Counter.getInstance();
        Counter c1 = Counter.getInstance();
        c1.count();
        c.times2();
        c.times2();
        for (int i = 0; i <10 ; i++) {
            c.times2();
            c1.count();
        }
        System.out.println(c1.getValue());
        System.out.println(c.getValue());
    }
}
