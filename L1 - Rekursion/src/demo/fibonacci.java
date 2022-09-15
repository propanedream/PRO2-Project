package demo;

import java.util.Locale;

public class fibonacci {


//    public static long fib(int n){
//        long result;
//        if (n==0){
//            result = 1;
//        }else if (n==1){
//            result = 1;
//        }else {
//            result = fib(n-1)
//        }
//    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);

        System.out.printf("%3s           %6s\n","n","fib(n)");
        System.out.printf("%4s=====%6s\n");
    }

    public static long fibIt(int n){
        if (n==0||n==1){
            return 1;
        }else{
            long fib_2 = 1;
            long fib_1 = 1;
            for (int i = 0;i<50;i++){
                long fib = fib_1+fib_2;
                fib_2 = fib_1;
                fib_1=fib;

            }
            return fib_1;
        }
    }
}
