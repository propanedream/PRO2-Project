package opgave3;

public abstract class Figur {
    private String navn;

    public Figur(String navn) {
        this.navn = navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void tegn() {
        System.out.println(navn);
    }

    public abstract double getareal();

    public abstract void addFigur(Figur figur);

    @Override
    public String toString() {
        return navn;
    }
}
