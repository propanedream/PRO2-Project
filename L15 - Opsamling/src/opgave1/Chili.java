package opgave1;

public class Chili implements Measureable, Filter  {
    private String navn;
    private int styrke;

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setStyrke(int styrke) {
        this.styrke = styrke;
    }

    public String getNavn() {
        return navn;
    }

    public int getStyrke() {
        return styrke;
    }

    public Chili(String navn, int styrke) {
        this.navn = navn;
        this.styrke = styrke;
    }

    @Override
    public double getMeasure() {
        return styrke;
    }

    @Override
    public String toString() {
        return "Chili{" +
                "navn='" + navn + '\'' +
                ", styrke=" + styrke +
                '}';
    }

    @Override
    public boolean accept(Object x) {
        return false;
    }
}
