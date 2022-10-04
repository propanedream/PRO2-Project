package controller;

import ordination.*;
import storage.*;

public class Controller implements StorageInterface{
    private StorageInterface storageInterface;
    private static Controller controller;

    private Controller(StorageInterface storageInterface) {
       this.storageInterface = storageInterface;
    }

    public static Controller getController(StorageInterface storageInterface) {
        if (controller == null) {
            controller = new Controller(storageInterface);
        }
        return controller;
    }

    /**
     * For et givent vægtinterval og et givent lægemiddel, hentes antallet af
     * ordinationer.
     * Pre: laegemiddel er ikke null
     */
    public int antalOrdinationerPrVægtPrLægemiddel(double vægtStart, double vægtSlut, Laegemiddel laegemiddel) {
        int antal = 0;
        for (Patient patient : storageInterface.getAllPatienter()) {
            if (patient.getVaegt() >= vægtStart && patient.getVaegt() <= vægtSlut) {
                for (Ordination ordination : patient.getOrdinationer()) {
                    if (ordination.getLaegemiddel().equals(laegemiddel)) {
                        antal++;
                    }
                }
            }
        }
        return antal;
    }
}
