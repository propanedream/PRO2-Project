package opgave3;

import java.util.Random;

public class Faelles {
    private int count;


    public synchronized void tagerRandomTid(int max) {
        Random r = new Random();
        int random = 0;
        int nymax = Math.abs(r.nextInt()) % max + 1;
        for (int i = 0; i < nymax; i++) {
            random++;
            random--;
            for (int j = 0; j < nymax; j++) {
                random++;
                random--;
            }
        }
    }

    public int getCount() {
        return count;
    }

    public synchronized void  kritiskSection() {
        int temp;
        temp = count;
        tagerRandomTid(50);
        count = temp + 1;
    }
}
