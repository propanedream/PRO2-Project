package model;

import java.util.ArrayList;

public interface ProduktgruppeInterface {

    ArrayList<ProduktInterface> getProdukter();
    void addProdukt(ProduktInterface produkt);
    void removeProdukt(ProduktInterface produkt);
}
