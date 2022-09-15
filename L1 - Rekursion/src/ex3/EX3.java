package ex3;

public class EX3 {
    public static int prod(int a, int b) {
        if (a == 0) {
            return 0;
        } else if (a == 1) {
            return b;
        } else
            return prod(a - 1, b) + b;

    }

//--------------------------------------

    public static int product(int a, int b) {
        int result;

        if (a * b == 0) {
            result = 0;
        } else {
            result = product((a - 1), b) + b;

        }
        System.out.println(1);
        return result;

    }

    //---------------------------------

    public static int productRus(int a, int b) {
        int result;

        if (a * b <= 0) {
            result = 0;
        } else if (a % 2 != 0&&a>=1) {
            result = productRus((a-1), b) + b;

        } else {
            result = productRus((a/2), (2*b));

        }

        System.out.println(1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(product(19, 3));
        System.out.println(productRus(19, 3));
        ;
    }
}
