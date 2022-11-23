package controller;

import gui.BetalingsFormer;
import model.*;
import model.Prisliste;
import model.Produkt;
import model.Salg;
import storage.Storage;

import java.util.ArrayList;

public class Controller {

    //    private static volatile Controller uniqueInstance;
//	private static StorageInterface storage;
//    private Controller() {
//		this.storage = StorageInterface.getInstance();
//    }
//    public static Controller getInstance() {
//        if(uniqueInstance == null) {
//            synchronized (Controller.class) {
//                if (uniqueInstance == null) {
//                    uniqueInstance = new Controller();
//                }
//            }
//        }
//        return uniqueInstance;
//    }
    // ------------------------------- betalingsform -------------------------------
    public static void addBetalingsFormTilSalg(Salg salg, BetalingsformerEnum betalingsformerEnum, int antal){
        salg.createBetalingsform(betalingsformerEnum, antal);

    }

    // ------------------------------- Prisliste -------------------------------
    public static PrislisteInterface createPrisliste(String navn) {
        PrislisteInterface prisliste = new Prisliste(navn);
        Storage.addPrisliste(prisliste);
        return prisliste;
    }

    public static ArrayList<PrislisteInterface> getPrislister() {
        return Storage.getPrislister();
    }

    public static void addProduktgruppeToPrisliste(ProduktgruppeInterface produktgruppe, PrislisteInterface prisliste) {
        prisliste.addProduktgruppe(produktgruppe);
    }

    // ------------------------------- Produktgruppe -------------------------------

    public static ProduktgruppeInterface createProduktgruppe(String navn) {
        ProduktgruppeInterface produktgruppe = new Produktgruppe(navn);
        Storage.addProduktgruppe(produktgruppe);
        return produktgruppe;
    }

    public static ArrayList<ProduktgruppeInterface> getProduktgrupper() {
        return Storage.getProduktgrupper();
    }

    public static void addProduktToProduktgruppe(ProduktInterface produkt, ProduktgruppeInterface produktgruppe) {
        produktgruppe.addProdukt(produkt);
    }

    // ------------------------------- Produkt -------------------------------

    public static ProduktInterface createProdukt(String navn) {
        ProduktInterface produkt = new Produkt(navn);
        Storage.addProdukt(produkt);
        return produkt;
    }

    public static ArrayList<ProduktInterface> getProdukts() {
        return Storage.getProdukter();
    }

    // ------------------------------- Kurv -------------------------------

    public static Kurv createKurv() {
        Kurv kurv = new Kurv();
        Storage.addKurv(kurv);
        return kurv;
    }

    public static KurvInterface removeKurv(KurvInterface kurv) {
        Storage.removeKurv(kurv);
        return kurv;
    }

    public static ArrayList<KurvInterface> getKurvs() {
        return Storage.getKurve();
    }

    public static void addProduktToKurv(ProduktInterface produkt, KurvInterface kurv, int antal) {
        produkt.setAntal(antal);
        kurv.addProdukt(produkt);
    }

    // ------------------------------- Salg -------------------------------

    public static SalgInterface createSalg(KurvInterface kurv, BetalingsForm betalingsForm) {
        SalgInterface salg = new Salg(kurv);
        Storage.addSalg(salg);
        return salg;
    }

    public static ArrayList<SalgInterface> getSalgs() {
        return Storage.getSalg();
    }

    // ------------------------------- Initialisering af storage -------------------------------

    public static void init() {
        ProduktgruppeInterface pg1 = createProduktgruppe("Flaske");
        ProduktInterface p1 = createProdukt("Klosterbryg");
        ProduktInterface p2 = createProdukt("Sweet Georgia Brown");
        ProduktInterface p3 = createProdukt("Extra Pilsner");
        ProduktInterface p4 = createProdukt("Celebration");
        ProduktInterface p5 = createProdukt("Blondie");
        ProduktInterface p6 = createProdukt("Forårsbryg");
        ProduktInterface p7 = createProdukt("India Pale Ale");
        ProduktInterface p8 = createProdukt("Julebryg");
        ProduktInterface p9 = createProdukt("Juletønden");
        ProduktInterface p10 = createProdukt("Old Strong Ale");
        ProduktInterface p11 = createProdukt("Fregatten Jylland");
        ProduktInterface p12 = createProdukt("Imperial Stout");
        ProduktInterface p13 = createProdukt("Tribute");
        ProduktInterface p14 = createProdukt("Black Monster");
        pg1.addProdukt(p1);
        pg1.addProdukt(p2);
        pg1.addProdukt(p3);
        pg1.addProdukt(p4);
        pg1.addProdukt(p5);
        pg1.addProdukt(p6);
        pg1.addProdukt(p7);
        pg1.addProdukt(p8);
        pg1.addProdukt(p9);
        pg1.addProdukt(p10);
        pg1.addProdukt(p11);
        pg1.addProdukt(p12);
        pg1.addProdukt(p13);
        pg1.addProdukt(p14);
        ProduktgruppeInterface pg2 = createProduktgruppe("Fadøl");
        ProduktInterface p15 = createProdukt("Klosterbryg");
        ProduktInterface p16 = createProdukt("Jazz Classic");
        ProduktInterface p17 = createProdukt("Extra Pilsner");
        ProduktInterface p18 = createProdukt("Celebration");
        ProduktInterface p19 = createProdukt("Blondie");
        ProduktInterface p20 = createProdukt("Forårsbryg");
        ProduktInterface p21 = createProdukt("India Pale Ale");
        ProduktInterface p22 = createProdukt("Julebryg");
        ProduktInterface p23 = createProdukt("Imperial Stout");
        ProduktInterface p24 = createProdukt("Special");
        pg2.addProdukt(p15);
        pg2.addProdukt(p16);
        pg2.addProdukt(p17);
        pg2.addProdukt(p18);
        pg2.addProdukt(p19);
        pg2.addProdukt(p20);
        pg2.addProdukt(p21);
        pg2.addProdukt(p22);
        pg2.addProdukt(p23);
        pg2.addProdukt(p24);
        ProduktgruppeInterface pg3 = createProduktgruppe("Drikke uden alkohol");
        ProduktInterface p25 = createProdukt("Æblebrus");
        ProduktInterface p26 = createProdukt("Cola");
        ProduktInterface p27 = createProdukt("Nikoline");
        ProduktInterface p28 = createProdukt("7-Up");
        ProduktInterface p29 = createProdukt("Vand");
        pg3.addProdukt(p25);
        pg3.addProdukt(p26);
        pg3.addProdukt(p27);
        pg3.addProdukt(p28);
        pg3.addProdukt(p29);
        ProduktgruppeInterface pg4 = createProduktgruppe("Snacks");
        ProduktInterface p30 = createProdukt("Chips");
        ProduktInterface p31 = createProdukt("Peanuts");
        ProduktInterface p32 = createProdukt("Ølpølser");
        pg4.addProdukt(p30);
        pg4.addProdukt(p31);
        pg4.addProdukt(p32);
        ProduktgruppeInterface pg5 = createProduktgruppe("Spiritus");
        ProduktInterface p33 = createProdukt("Whisky 45% 50 cl rør");
        ProduktInterface p34 = createProdukt("Whisky 4 cl.");
        ProduktInterface p35 = createProdukt("Whisky 43% 50 cl rør");
        ProduktInterface p36 = createProdukt("u/ egesplint");
        ProduktInterface p37 = createProdukt("m/ egesplint");
        ProduktInterface p38 = createProdukt("2*whisky glas + brikker");
        ProduktInterface p39 = createProdukt("Liquor of Aarhus");
        ProduktInterface p40 = createProdukt("Lyng gin 50 cl");
        ProduktInterface p41 = createProdukt("Lyng gin 4 cl");
        pg5.addProdukt(p33);
        pg5.addProdukt(p34);
        pg5.addProdukt(p35);
        pg5.addProdukt(p36);
        pg5.addProdukt(p37);
        pg5.addProdukt(p38);
        pg5.addProdukt(p39);
        pg5.addProdukt(p40);
        pg5.addProdukt(p41);
        ProduktgruppeInterface pg6 = createProduktgruppe("Fustage");
        ProduktInterface p42 = createProdukt("Klosterbryg, 20 liter");
        ProduktInterface p43 = createProdukt("Jazz Classic, 25 liter");
        ProduktInterface p44 = createProdukt("Extra Pilsner, 25 liter");
        ProduktInterface p45 = createProdukt("Celebration, 20 liter");
        ProduktInterface p46 = createProdukt("Blondie, 25 liter");
        ProduktInterface p47 = createProdukt("Forårsbryg, 20 liter");
        ProduktInterface p48 = createProdukt("India Pale Ale, 20 liter");
        ProduktInterface p49 = createProdukt("Julebryg, 20 liter");
        ProduktInterface p50 = createProdukt("Imperial Stout, 20 liter");
        ProduktInterface p51 = createProdukt("Pant");
        pg6.addProdukt(p42);
        pg6.addProdukt(p43);
        pg6.addProdukt(p44);
        pg6.addProdukt(p45);
        pg6.addProdukt(p46);
        pg6.addProdukt(p47);
        pg6.addProdukt(p48);
        pg6.addProdukt(p49);
        pg6.addProdukt(p50);
        pg6.addProdukt(p51);
        ProduktgruppeInterface pg7 = createProduktgruppe("Kulsyre");
        ProduktInterface p52 = createProdukt("6 kg");
        ProduktInterface p53 = createProdukt("Pant");
        ProduktInterface p54 = createProdukt("4 kg");
        ProduktInterface p55 = createProdukt("10 kg");
        pg7.addProdukt(p52);
        pg7.addProdukt(p53);
        pg7.addProdukt(p54);
        pg7.addProdukt(p55);
        ProduktgruppeInterface pg8 = createProduktgruppe("Malt");
        ProduktInterface p56 = createProdukt("25 kg sæk");
        pg8.addProdukt(p56);
        ProduktgruppeInterface pg9 = createProduktgruppe("Beklædning");
        ProduktInterface p57 = createProdukt("T-shirt");
        ProduktInterface p58 = createProdukt("Polo");
        ProduktInterface p59 = createProdukt("Cap");
        pg9.addProdukt(p57);
        pg9.addProdukt(p58);
        pg9.addProdukt(p59);
        ProduktgruppeInterface pg10 = createProduktgruppe("Anlæg");
        ProduktInterface p60 = createProdukt("1-hane");
        ProduktInterface p61 = createProdukt("2-haner");
        ProduktInterface p62 = createProdukt("Bar med flere haner");
        ProduktInterface p63 = createProdukt("Levering");
        ProduktInterface p64 = createProdukt("Krus");
        pg10.addProdukt(p60);
        pg10.addProdukt(p61);
        pg10.addProdukt(p62);
        pg10.addProdukt(p63);
        pg10.addProdukt(p64);
        ProduktgruppeInterface pg11 = createProduktgruppe("Glas");
        ProduktInterface p65 = createProdukt("Uanset størrelse");
        pg11.addProdukt(p65);
        ProduktgruppeInterface pg12 = createProduktgruppe("Sampakninger");
        ProduktInterface p66 = createProdukt("Gaveæske 2 øl, 2 glas");
        ProduktInterface p67 = createProdukt("Gaveæske 4 øl");
        ProduktInterface p68 = createProdukt("Trækasse 6 øl");
        ProduktInterface p69 = createProdukt("Gavekurv 6 øl, 2 glas");
        ProduktInterface p70 = createProdukt("Trækasse 6 øl, 6 glas");
        ProduktInterface p71 = createProdukt("Trækasse 12 øl");
        ProduktInterface p72 = createProdukt("Papkasse 12 øl");
        pg12.addProdukt(p66);
        pg12.addProdukt(p67);
        pg12.addProdukt(p68);
        pg12.addProdukt(p69);
        pg12.addProdukt(p70);
        pg12.addProdukt(p71);
        pg12.addProdukt(p72);
        ProduktgruppeInterface pg13 = createProduktgruppe("Rundvisning");
        ProduktInterface p73 = createProdukt("Pr person dag");
        pg13.addProdukt(p73);
        PrislisteInterface pl1 = createPrisliste("Fredagsbar");
        pl1.addProduktgruppe(pg1);
        pl1.addProduktgruppe(pg2);
        pl1.addProduktgruppe(pg3);
        pl1.addProduktgruppe(pg5);
        pl1.addProduktgruppe(pg7);
        pl1.addProduktgruppe(pg9);
        pl1.addProduktgruppe(pg12);
        PrislisteInterface pl2 = createPrisliste("Butik");
        pl2.addProduktgruppe(pg1);
        pl2.addProduktgruppe(pg3);
        pl2.addProduktgruppe(pg4);
        pl2.addProduktgruppe(pg5);
        pl2.addProduktgruppe(pg6);
        pl2.addProduktgruppe(pg7);
        pl2.addProduktgruppe(pg8);
        pl2.addProduktgruppe(pg9);
        pl2.addProduktgruppe(pg10);
        pl2.addProduktgruppe(pg11);
        pl2.addProduktgruppe(pg12);
        pl2.addProduktgruppe(pg13);
        KurvInterface k1 = createKurv();

//		BetalingsForm betalingsForm = new BetalingsForm("klippekort", "klip", )
    }
}
