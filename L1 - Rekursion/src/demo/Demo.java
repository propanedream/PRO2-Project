package demo;

public class Demo {
    public static void f(int n){
        int a = 8;
        System.out.println("in f(" + n + ")");
        if (n>-3)
        f(n-1);
        System.out.println("slut " + n);
    }

    public static void g(int m){
        int b = 7;
        System.out.println("int g(" + m + ")");

    }

    public static void main(String[] args) {
        f(2);
    }

   // -----------------------------------------------------------------------


    public static void fRec(int n){
        if (n==0){
            System.out.println(0);

        }else {
            fRec(n-1);
            System.out.println(n);
        }
    }




    //---------------------------------------------------------------

}
