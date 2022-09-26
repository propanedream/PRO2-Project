package opgave2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bibliotek {
    /*
     * Returnerer størrelsen af bøden beregnet i henhold til skemaet
     * ovenfor
     * krav: beregnetDato og faktiskDato indeholder lovlige datoer og
     *       beregnetDato < faktiskDato
     *      (beregnetDato er forventet afleveringsdato og
     *       faktiskDato er den dag bogen blev afleveret; voksen er
     *       sand, hvis det er en voksen og falsk ellers)
     */
//    public int beregnBøde(LocalDate beregnetDato, LocalDate faktiskDato, boolean voksen){
//       //shorthand boolean
//        return voksen ? 20 : 10;
//    }
//    public int beregnBøde(LocalDate beregnetDato, LocalDate faktiskDato, boolean voksen){
//        int dageOverskredet = (int) ChronoUnit.DAYS.between(beregnetDato, faktiskDato);
//        return dageOverskredet > 7 ?
//                voksen ? 60 : 30 :
//                voksen ? 20 : 10;
//    }


    public int beregnBøde(LocalDate beregnetDato, LocalDate faktiskDato, boolean voksen) {
        //shorthand boolean
        int dageOverskredet = (int) ChronoUnit.DAYS.between(beregnetDato, faktiskDato);

        if (dageOverskredet > 14) {
            return voksen ? 90 : 45;
        } else if (dageOverskredet > 7) {
            return voksen ? 60 : 30;
        } else if (dageOverskredet < 7) {
            return voksen ? 20 : 10;
        }

        return 0;
    }


}









