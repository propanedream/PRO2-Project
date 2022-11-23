package model;

import java.util.ArrayList;

public interface KurvInterface {
    ArrayList<ProduktInterface> getProdukter();
    void addProdukt(ProduktInterface produkt);
    void removeProdukt(ProduktInterface produkt);
}
