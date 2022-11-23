package storage;

import model.*;

import java.util.ArrayList;

public interface StorageInterface {
//    static Storage getInstance() {
//        return Storage.getUniqueInstance();
//    }

    ArrayList<PrislisteInterface> getPrislister();
    void addPrisliste(PrislisteInterface prisliste);
    ArrayList<ProduktgruppeInterface> getProduktgrupper();
    void addProduktgruppe(ProduktgruppeInterface produktgruppe);
    ArrayList<KurvInterface> getKurve();
    void addKurv(KurvInterface kurv);
    void removeKurv(KurvInterface kurv);
    ArrayList<ProduktInterface> getProdukter();
    void addProdukt(ProduktInterface produkt);
    ArrayList<SalgInterface> getSalg();
    void addSalg(SalgInterface salg);
}
