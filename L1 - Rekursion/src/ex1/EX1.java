package ex1;

public class EX1 {
    public int factorial(int n) {
        int result = 0;

        if (n == 0) {
            result = 1;
        } else {
            result = factorial(n - 1) * n;

        }
        return result;
    }

    public static void main(String[] args) {
        EX1 ex = new EX1();
        System.out.println(ex.factorial(4));
    }
}
