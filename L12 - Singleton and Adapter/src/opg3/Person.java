package opg3;

public class Person {
    private int alder;
    private String navn;

    PersonAdministrator personAdministrator;

    public PersonAdministrator getPersonAdministrator() {
        return personAdministrator;
    }

    public Person(int alder, String navn) {
        this.alder = alder;
        this.navn = navn;
    }

    public int getAlder() {
        return alder;
    }

    public String getNavn() {
        return navn;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return "Person{" +
                "alder=" + alder +
                ", navn='" + navn + '\'' +
                ", personAdministrator=" + personAdministrator +
                '}';
    }
}
