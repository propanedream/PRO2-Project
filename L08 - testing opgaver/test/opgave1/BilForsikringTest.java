package opgave1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilForsikringTest {
private BilForsikring bilForsikring = new BilForsikring();

//    @BeforeEach
//    void setUp() {
//        int alder = 20;
//      this.bilForsikring = new BilForsikring();
//    }
    @Test
    @Order(1)
    void beregnPraemie_18_aarig_mand_skadesfriaar_0() {
        //arrange
        int alder = 18;
        boolean isKvinde = false;
        int skadeFrieaer = 0;

        //act
        double expected = 6250;
        bilForsikring.setGrundpaemie(5000);
        double actual =  bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaer);

        //assert
        assertEquals(expected, actual);
    }


    @Test
    @Order(2)
    void beregnPraemie_18_aarigKvinde_skadesfriaar_0() {
        //arrange
        int alder = 18;
        boolean isKvinde = true;
        int skadeFrieaer = 0;

        //act
        double expected = 5937.5;
        bilForsikring.setGrundpaemie(5000);
        double actual =  bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaer);

        //assert
        assertEquals(expected, actual);
    }


    @Test
    @Order(3)
    void beregnPraemie_25_aarigMand_skadesfriaar_3() {
        //arrange
        int alder = 25;
        boolean isKvinde = false;
        int skadeFrieaer = 3;

        //act
        double expected = 3400;
        bilForsikring.setGrundpaemie(4000);
        double actual =  bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaer);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    @Order(4)
    void beregnPraemie_25_aarigKvinde_skadesfriaar_3() {
        //arrange
        int alder = 25;
        boolean isKvinde = true;
        int skadeFrieaer = 3;

        //act
        double expected = 3230;
        bilForsikring.setGrundpaemie(4000);
        double actual =  bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaer);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    @Order(5)
    void beregnPraemie_26_aarigMand_skadesfriaar_6() {
        //arrange
        int alder = 26;
        boolean isKvinde = false;
        int skadeFrieaer = 6;

        //act
        double expected = 3000;
        bilForsikring.setGrundpaemie(4000);
        double actual =  bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaer);

        //assert
        assertEquals(expected, actual);
    }


    @Test
    @Order(6)
    void beregnPraemie_26_aarigKvinde_skadesfriaar_6() {
        //arrange
        int alder = 26;
        boolean isKvinde = true;
        int skadeFrieaer = 6;

        //act
        double expected = 2850;
        bilForsikring.setGrundpaemie(4000);
        double actual =  bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaer);

        //assert
        assertEquals(expected, actual);
    }


    @Test
    @Order(7)
    void beregnPraemie_30_aarigMand_skadesfriaar_10() {
        //arrange
        int alder = 30;
        boolean isKvinde = false;
        int skadeFrieaer = 10;

        //act
        double expected = 2600;
        bilForsikring.setGrundpaemie(4000);
        double actual =  bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaer);

        //assert
        assertEquals(expected, actual);
    }


    @Test
    @Order(8)
    void beregnPraemie_26_aarigKvinde_skadesfriaar_10() {
        //arrange
        int alder = 30;
        boolean isKvinde = true;
        int skadeFrieaer = 10;

        //act
        double expected = 2470;
        bilForsikring.setGrundpaemie(4000);
        double actual =  bilForsikring.beregnPraemie(alder, isKvinde, skadeFrieaer);

        //assert
        assertEquals(expected, actual);
    }



}