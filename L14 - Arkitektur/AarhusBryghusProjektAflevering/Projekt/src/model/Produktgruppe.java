package model;

import java.util.ArrayList;

public class Produktgruppe implements ProduktgruppeInterface {
	private String navn;
	private ArrayList<ProduktInterface> produkts = new ArrayList<>();

	public Produktgruppe(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	@Override
	public String toString() {
		return navn;
	}

	// -------------------------------------------------------------------------

	public ArrayList<ProduktInterface> getProdukter() {
		return new ArrayList<>(produkts);
	}

	public void addProdukt(ProduktInterface produkt) {
		if (!produkts.contains(produkt)) {
			produkts.add(produkt);
		}
	}

	public void removeProdukt(ProduktInterface produkt) {
		if (produkts.contains(produkt)) {
			produkts.remove(produkt);
		}
	}
}
