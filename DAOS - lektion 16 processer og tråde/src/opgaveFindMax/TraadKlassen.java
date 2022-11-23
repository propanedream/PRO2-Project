package opgaveFindMax;

public class TraadKlassen extends Thread {

    //Att
    private int max;
    private int[] traadArray;

    public TraadKlassen(int[] traadArray) {
        super();
        this.traadArray = traadArray;

    }

    public void run() {
        max = Integer.MIN_VALUE;
        for (int i = 0; i < traadArray.length; i++) {
            if (traadArray[i] > max) {
                max = Math.max(traadArray[i], i);
            }
        }
    }

    public int getMax() {
        return max;
    }
}
