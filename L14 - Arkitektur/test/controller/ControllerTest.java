package controller;

import ordination.Laegemiddel;
import ordination.Ordination;
import ordination.Patient;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import storage.StorageInterface;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ControllerTest {

    @Test
    void getController() {
    }

    @Test
    void antalOrdinationerPrVægtPrLægemiddel() {
        //arrange


        StorageInterface storageMock = mock(StorageInterface.class);
        Patient patientmock = mock(Patient.class);
        Ordination ordinationMock =  mock(Ordination.class);


        List<Patient> patientlist = new ArrayList<>();
        List<Ordination> ordinationer = new ArrayList<>();


        Controller controller = new Controller(storageMock);
        Laegemiddel laegemiddel= new Laegemiddel("XTC", 1.0, 2.0, 3.0, "stk");
        Laegemiddel laegemiddel1= new Laegemiddel("XTCx2", 1.0, 2.0, 3.0, "stk");


        ordinationer.add(ordinationMock);


        patientlist.add(patientmock);
        patientlist.add(patientmock);
        patientlist.add(patientmock);


        when(patientmock.getOrdinationer()).thenReturn(ordinationer);
        // der skrives en ekstra variabel ind i parameteren, dette betyder at
        // første gang denne metode kaldes bliver første lægemiddel brugt, anden
        // gang lægemiddel 2
        when(ordinationMock.getLaegemiddel()).thenReturn(laegemiddel, laegemiddel1);
        when(storageMock.getAllPatienter()).thenReturn(patientlist);
        when(patientmock.getVaegt()).thenReturn(85.0);

        //act
        double actual = controller.antalOrdinationerPrVægtPrLægemiddel(80.0, 100, laegemiddel1);
        double expected = 2;
        //assert
        assertEquals(expected, actual);
    }
}