package model;

import java.util.ArrayList;

public interface ProduktInterface {

    String getNavn();
    int getAntal();
    ArrayList<Double> getPriss();
    void addPris(Double pris);
    void setPris(int index, Double pris);
    void removePris(Double pris);
    void setAntal(int antal);
    String toString();
}
