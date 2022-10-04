package opg3;

import java.util.ArrayList;



public class PersonAdministrator {
    private String navn;
    private ArrayList<Person> personer = new ArrayList<>();
    private static PersonAdministrator uniqueInstance;

    private PersonAdministrator() {
    }

    public static PersonAdministrator getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PersonAdministrator();
        }
        return uniqueInstance;
    }

    public void addperson(Person person) {
        personer.add(person);
        person.personAdministrator = this;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Person> getPersoner() {
        return personer;
    }

    public void removePerson(Person person) {
        personer.remove(person);
    }

    @Override
    public String toString() {
        return  navn ;
    }
}
