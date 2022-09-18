package opgave1;

public class BilForsikring {
    // angiver den til enhver tid gældende
    // grundpræmie for en bilforsikring
    private double grundPræmie;

    /**
     * Registrerer bilforsikringens grundPræmie
     */
    public void setGrundPræmie(double grundPræmie) {
    }

/**
 * Beregner og returnerer en præmie udregnet ud fra følgende regler:
 * grundPræmie danner udgangspunkt for præmien
 * hvis der er tale om unge under 25 tillægges grundPræmien 25%
 * hvis der er tale om en kvinde reduceres præmien med       5%
 * hvis man har kørt skadefrit i:
 *    0 til 2 år reduceres præmien med  0%
 *    3 til 5 år reduceres præmien med 15%
 *    6 til 8 år reduceres præmien med 25%
 *    over  8 år reduceres præmien med 35%
 * ovenstående skal udregnes i den angivne rækkefølge
 *
 * Krav: grundPræmie er tildelt værdi.
 */
public double beregnPræmie(int     alder, boolean isKvinde, int     skadeFrieÅr) {
    return  0;
}
}