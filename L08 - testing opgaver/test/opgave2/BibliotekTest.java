package opgave2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.midi.VoiceStatus;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BibliotekTest {
private    Bibliotek bib = new Bibliotek();

    @BeforeEach
    public void setUp(){
        bib = new Bibliotek();
    }
    @Test
    void test_beregnBoede_1dag_barn() {
        //arrange
        java.time.LocalDate beregnetDato = LocalDate.of(2022, 10, 10);
        LocalDate faktiskDato = LocalDate.of(2022, 10, 11);
        boolean voksen = false;

        //act
        int expected = 10;
        int actual = bib.beregnBøde(beregnetDato, faktiskDato, voksen);

        //assert
        assertEquals(expected,actual );
    }

    @Test
    void test_beregnBoede_1dag_voksen() {
        //arrange
        java.time.LocalDate beregnetDato = LocalDate.of(2022, 10, 10);
        LocalDate faktiskDato = LocalDate.of(2022, 10, 11);
        boolean voksen = true;

        //act
        int expected = 20;
        int actual = bib.beregnBøde(beregnetDato, faktiskDato, voksen);

        //assert
        assertEquals(expected,actual );
    }


    @Test
    void test_beregnBoede_8dag_barn() {
        //arrange
        java.time.LocalDate beregnetDato = LocalDate.of(2022, 10, 10);
        LocalDate faktiskDato = LocalDate.of(2022, 10, 18);
        boolean voksen = false;

        //act
        int expected = 30;
        int actual = bib.beregnBøde(beregnetDato, faktiskDato, voksen);

        //assert
        assertEquals(expected,actual );
    }

    @Test
    void test_beregnBoede_8dag_voksen() {
        //arrange
        java.time.LocalDate beregnetDato = LocalDate.of(2022, 10, 10);
        LocalDate faktiskDato = LocalDate.of(2022, 10, 18);
        boolean voksen = true;

        //act
        int expected = 60;
        int actual = bib.beregnBøde(beregnetDato, faktiskDato, voksen);

        //assert
        assertEquals(expected,actual );
    }


    @Test
    void test_beregnBoede_16dag_barn() {
        //arrange
        java.time.LocalDate beregnetDato = LocalDate.of(2022, 10, 10);
        LocalDate faktiskDato = LocalDate.of(2022, 10, 26);
        boolean voksen = false;

        //act
        int expected = 45;
        int actual = bib.beregnBøde(beregnetDato, faktiskDato, voksen);

        //assert
        assertEquals(expected,actual );
    }

    @Test
    void test_beregnBoede_16dag_voksen() {
        //arrange
        java.time.LocalDate beregnetDato = LocalDate.of(2022, 10, 10);
        LocalDate faktiskDato = LocalDate.of(2022, 10, 26);
        boolean voksen = true;

        //act
        int expected = 90;
        int actual = bib.beregnBøde(beregnetDato, faktiskDato, voksen);

        //assert
        assertEquals(expected,actual );
    }
}