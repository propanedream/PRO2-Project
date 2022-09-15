package opgave5;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Studerende implements Comparable<Studerende> {
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
    public void addKarakter(int karakter) {
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


    @Override
    public int compareTo(Studerende o) {
//        return Integer.compare(this.getStudieNr(), o.getStudieNr());
        int comp = 0;
        if (o.studieNr > this.studieNr) {
            comp = -1; //så kommer this først

        } else if (o.studieNr < this.studieNr) {
            comp = 1;
        }

        return comp;
    }
}
