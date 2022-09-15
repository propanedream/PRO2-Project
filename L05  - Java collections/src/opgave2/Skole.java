package opgave2;

import java.awt.*;
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
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).getStudieNr()==studieNr){
                return students.get(i);
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
