package demo;

public class demo2 {
    public static void fRec(int n){
        if (n==0){
            System.out.println(0);

        }else {
            fRec(n-1);
            System.out.println(n);
        }
    }
    public static void main(String[] args) {
        System.out.printf("8%s", "i: ");
        for (int i = 0;i<10;i++){

        }
        System.out.printf("%8s", "f(i):");
        for (int i = 0;i<10;i++){

        }
    }
}
