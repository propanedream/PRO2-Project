package opgave3;

public class Elipse extends Figur {
    private double r1;
    private double r2;

    public Elipse(String navn, double r1, double r2) {
        super(navn);
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public double getareal() {
        return 0;
    }

    @Override
    public void addFigur(Figur figur) {

    }
}
