package opgave2;

import java.util.Random;

public class Faelles {
    private int count;
    boolean flag[];
    int turn;

    public Faelles(){
        flag = new boolean[2];
        flag[0] = false;
        flag[1] = false;
    }

    public void tagerRandomTid(int max) {
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

    public void kritiskSection() {
        int temp;
        temp = count;
        tagerRandomTid(50);
        count = temp + 1;
    }

    public boolean getFlag(int id) {
        return flag[id];
    }

    public void setFlag(boolean flag, int id) {
        this.flag[id] = flag;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
