package opgave2;

public class Counter {
    private int value;
    private static Counter uniqueInstance;

    private Counter(int value) {
        this.value = value;
    }

    public static Counter getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Counter(0);
        }
        return uniqueInstance;
    }

    public void count() {
        value = value + 1;
    }

    public void times2() {
        value = value * 2;
    }

    public void zero() {
        value = value * 0;
    }

    public int getValue() {
        return value;
    }
}
