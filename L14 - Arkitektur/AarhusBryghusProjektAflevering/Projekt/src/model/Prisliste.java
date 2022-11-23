package model;

import java.util.ArrayList;

public class Prisliste implements PrislisteInterface {
	private String navn;
	private ArrayList<ProduktgruppeInterface> produktgruppes = new ArrayList<>();

	public Prisliste(String navn) {
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

	public ArrayList<ProduktgruppeInterface> getProduktgrupper() {
		return new ArrayList<>(produktgruppes);
	}

	public void addProduktgruppe(ProduktgruppeInterface produktgruppe) {
		if (!produktgruppes.contains(produktgruppe)) {
			produktgruppes.add(produktgruppe);
		}
	}

	public void removeProduktgruppe(ProduktgruppeInterface produktgruppe) {
		if (produktgruppes.contains(produktgruppe)) {
			produktgruppes.remove(produktgruppe);
		}
	}
}
