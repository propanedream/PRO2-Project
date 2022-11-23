package model;

import java.util.ArrayList;

public interface PrislisteInterface {
    String getNavn();
    ArrayList<ProduktgruppeInterface> getProduktgrupper();
    void addProduktgruppe(ProduktgruppeInterface produktgruppe);
    void removeProduktgruppe(ProduktgruppeInterface produktgruppe);
}
