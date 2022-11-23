package model;

import java.util.ArrayList;

public class Produkt implements ProduktInterface {
	private String navn;
	private ArrayList<Double> priss = new ArrayList<>();
	private int antal;

	public Produkt(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public ArrayList<Double> getPriss() {
		return new ArrayList<>(priss);
	}

	public void addPris(Double pris) {
		priss.add(pris);
	}

	public void setPris(int index, Double pris) {
		priss.set(index, pris);
	}

	public void removePris(Double pris) {
		priss.remove(pris);
	}

	public int getAntal() {
		return antal;
	}

	public void setAntal(int antal) {
		this.antal = antal;
	}

	@Override
	public String toString() {
		if (priss.isEmpty() && antal == 0) {
			return navn;
		} else if (priss.isEmpty()) {
			return navn + " " + antal;
		} else if (antal == 0) {
			return navn + " " + priss;
		} else {
			return navn + " " + antal + " " + priss;
		}
	}
}