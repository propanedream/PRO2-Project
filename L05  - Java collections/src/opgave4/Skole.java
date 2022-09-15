package opgave4;

import java.util.*;

public class Skole {
    private String navn;

    //--------------------
    //0..1 --> 0..* Studerende
    private final HashMap<Integer, Studerende> students = new HashMap<>();
    //--------------------

    public Skole(String navn) {
        this.navn = navn;
    }

    //--------------------

    public HashMap<Integer, Studerende> getStudents() {
        return new HashMap<Integer, Studerende>(students);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    //--------------------
    public void addStuderence(Studerende studerende) {
        students.put(studerende.getStudieNr(), studerende);
    }

    public void removeStuderende(Studerende studerende) {
        students.remove(studerende.getStudieNr(), studerende);
    }

    public double gennemsnit() {
        int samlet = 0;
        for (Studerende s : students.values()) {
            for (int j = 0; j < s.getKarakterer().size(); j++) {
                samlet += s.getKarakterer().get(j);
            }
        }
        double avg = samlet;
        return avg / students.size();
    }
    //
    public double gennemsnit1(){
        int count = 0;
        double totalK = 0;
        for (Studerende s : students.values()){
            for (int k : s.getKarakterer()){
                totalK = totalK + k;
                count++;
            }
        }
        return totalK/count;
    }
    public Studerende findStuderende(int studieNr) {
        if (students.containsKey(studieNr)) {
            return students.get(studieNr);
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
