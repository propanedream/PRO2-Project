package opgave5;

import java.util.ArrayList;
import java.util.List;

public class Skole {
    private String navn;

    //--------------------
    //0..1 --> 0..* Studerende
    private final List<Studerende> students = new ArrayList<>();
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
        for (Studerende student : students) {
            for (int j = 0; j < students.get(j).getKarakterer().size(); j++) {
                samlet = samlet + student.getKarakterer().get(j);
            }
        }
        double avg = samlet;
        return avg/students.size();
    }

    public Studerende findStuderende(int studieNr){
        for (Studerende student : students) {
            if (student.getStudieNr() == studieNr) {
                return student;
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
