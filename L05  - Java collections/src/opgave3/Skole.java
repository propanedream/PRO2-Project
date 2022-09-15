package opgave3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Skole  {
    private String navn;

    //--------------------
    //0..1 --> 0..* Studerende
    private final HashSet<Studerende> students = new HashSet<>();
    //--------------------

    public Skole(String navn) {
        this.navn = navn;
    }

    //--------------------

    public List<Studerende> getStudents() {
        return new ArrayList<>(students);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    //--------------------
    public void addStuderence(Studerende studerende){
        students.add(studerende);
    }
    public void removeStuderende (Studerende studerende){
    students.remove(studerende);
    }
    public double gennemsnit(){
        int samlet = 0;
        for (Studerende s : students){
            for (int j = 0; j < s.getKarakterer().size(); j++) {
                samlet +=s.getKarakterer().get(j);
            }
        }
        double avg = samlet;
        return avg/students.size();
    }


    //antallet af karakterer er ikke lige så stort som antal karakterer, derfor
    //bruges en counter til at kunne dividere og finde gennemsnittet
    //tidskompleksiten kan ikke helt beskrives som N^2, da listerne i brug ikke
    // er lige store
    public double gennemsnit1(){
        int count = 0;
        double totalK = 0;
        for (Studerende s : students){
            for (int k : s.getKarakterer()){
                totalK = totalK + k;
                count++;
            }
        }
        return totalK/count;
    }

    public Studerende findStuderende(int studieNr){
       for (Studerende s : students){
           if (s.getStudieNr() == studieNr){
               return s;
           }
       }
    return null;
    }

    @Override
    public String toString() {
        return "Skole{" +
                "navn='" + navn + '\'' +
                '}';
    }
}
