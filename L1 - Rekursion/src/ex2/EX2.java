package ex2;

public class EX2 {
    public static long power(int n, int p) {
        long result = 0;
        if (p == 0) {
            result = 1;
        } else {
            result = power(n, p - 1) * n;
//            System.out.println("power1; " + result);

        }
        System.out.println("power: " + result);
        return result;
    }

//    public static long power2(int n, int p) {
//        long result = 0;
//        if (p == 0) {
//            result = 1;
//        } else if (p % 2 !=0) {
//            result = power2(n, p - 1) * n;
//
//
//        } else   {
//        result=power2(n*n, p/2)*n;
//            System.out.println("power 2; " + result);
//        }
//        return result;
//    }

    public static long power2(int n, int p) {
        long result = 0;
        if (p == 0) {
            result = 1;
        } else if (p % 2 != 0) {
            result = n * power2(n, p - 1);
        } else
            result = power2(n * n, p / 2);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 2));
        System.out.println(power2(2, 3));
    }
}
