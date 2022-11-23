package storage;

import model.*;

import java.util.ArrayList;

public class Storage{
//	private static volatile Storage uniqueInstance;
	private static ArrayList<PrislisteInterface> prislister = new ArrayList<>();
	private static ArrayList<ProduktgruppeInterface> produktgrupper = new ArrayList<>();
	private static ArrayList<ProduktInterface> produkter = new ArrayList<>();
	private static ArrayList<KurvInterface> kurve = new ArrayList<>();
	private static ArrayList<SalgInterface> salgListe = new ArrayList<>();

//	private Storage() {
//
//	}
//	public static Storage getUniqueInstance() {
//		if(uniqueInstance == null) {
//			synchronized (Storage.class) {
//				if (uniqueInstance == null) {
//					uniqueInstance = new Storage();
//				}
//			}
//		}
//		return uniqueInstance;
//	}

	// ---------------------------Prislistes----------------------------------------------

	public static ArrayList<PrislisteInterface> getPrislister() {
		return new ArrayList<>(prislister);
	}

	public static void addPrisliste(PrislisteInterface prisliste) {
		prislister.add(prisliste);
	}

	// ---------------------------Produktgruppes----------------------------------------------

	public static ArrayList<ProduktgruppeInterface> getProduktgrupper() {
		return new ArrayList<>(produktgrupper);
	}

	public static void addProduktgruppe(ProduktgruppeInterface produktgruppe) {
		produktgrupper.add(produktgruppe);
	}

	// ---------------------------Kurvs----------------------------------------------

	public static ArrayList<KurvInterface> getKurve() {
		return new ArrayList<KurvInterface>(kurve);
	}

	public static void addKurv(KurvInterface kurv) {
		kurve.add(kurv);
	}

	public static void removeKurv(KurvInterface kurv) {
		kurve.remove(kurv);
	}

	// ---------------------------Produkts----------------------------------------------

    public static ArrayList<ProduktInterface> getProdukter() {
        return new ArrayList<ProduktInterface>(produkter);
    }

    public static void addProdukt(ProduktInterface produkt) {
        produkter.add(produkt);
    }

	// ---------------------------Salgs----------------------------------------------

	public static ArrayList<SalgInterface> getSalg() {
		return new ArrayList<>(salgListe);
	}

	public static void addSalg(SalgInterface salg) {
		salgListe.add(salg);
	}
}
