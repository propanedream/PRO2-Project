package model;

import java.util.ArrayList;

public class Kurv implements KurvInterface {
	private final ArrayList<ProduktInterface> produkter = new ArrayList<>();

	@Override
	public String toString() {
		if (produkter.isEmpty()) {
			return "Kurven er tom";
		} else {
			return "" + produkter;
		}
	}

	// -------------------------------------------------------------------------



	public ArrayList<ProduktInterface> getProdukter() {
		return new ArrayList<>(produkter);
	}

	public void addProdukt(ProduktInterface produkt) {
		if (!produkter.contains(produkt)) {
			produkter.add(produkt);
		}
	}

	public void removeProdukt(ProduktInterface produkt) {
		if (produkter.contains(produkt)) {
			produkter.remove(produkt);
		}
	}
	public double samletPrisForKurv() {
		double samletPris = 0;
		for (ProduktInterface p : produkter) {
			samletPris += p.getPriss().get(0)*p.getAntal();
		}
		return samletPris;
	}
}
