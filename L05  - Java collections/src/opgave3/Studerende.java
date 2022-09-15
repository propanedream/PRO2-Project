package opgave3;

import java.util.ArrayList;
import java.util.List;

public class Studerende {
    private int studieNr;
    private String navn;

    private List<Integer> karakterer = new ArrayList<>();

    //--------------------

    public Studerende(int studieNr, String navn) {
        this.studieNr = studieNr;
        this.navn = navn;

    }

    //--------------------

    public int getStudieNr() {
        return studieNr;
    }

    public void setStudieNr(int studieNr) {
        this.studieNr = studieNr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public List<Integer> getKarakterer() {
        return karakterer;
    }

    public void setKarakterer(List<Integer> karakterer) {
        this.karakterer = karakterer;
    }

    //--------------------
    public void addKarakter(int karakter){
        karakterer.add(karakter);
    }

    @Override
    public String toString() {
        return "Studerende{" +
                "studieNr=" + studieNr +
                ", navn='" + navn + '\'' +
                ", karakterer=" + karakterer +
                '}';
    }
}
