package ex4;

public class Opgave4 {

    public static String reverse(String s) {
        if (s.isEmpty()) {
            System.out.println("string is empty");
            return s;
        } else {
            System.out.println("sub: " + s.substring(1));
            System.out.println("char: "  + s.charAt(0));
            return reverse(s.substring(1)) + s.charAt(0);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse("ire aY"));
    }
}
