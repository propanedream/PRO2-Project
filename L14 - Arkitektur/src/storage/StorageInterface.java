package storage;

import ordination.Patient;

import java.util.List;

public interface StorageInterface {
    /**
     * Returnerer en liste med alle gemte patienter
     */
    default List<Patient> getAllPatienter() {
        throw new UnsupportedOperationException();
    }

}
