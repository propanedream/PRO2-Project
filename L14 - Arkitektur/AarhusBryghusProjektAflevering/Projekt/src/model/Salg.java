package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salg implements SalgInterface {
	private int id;
	private LocalDate dato;
	private KurvInterface kurv;

	//--------------------
	// composition 1 -> 0..* betalingsform
	private final ArrayList<BetalingsForm> betalingsFormer = new ArrayList<>();

	public ArrayList<BetalingsForm> getBetalingsForms() {
		return new ArrayList<>(betalingsFormer);
	}
	public BetalingsForm createBetalingsform(BetalingsformerEnum betalingsformerEnum, int antal){
		BetalingsForm betalingsForm = new BetalingsForm(betalingsformerEnum,antal);
		betalingsFormer.add(betalingsForm);
		return betalingsForm;
	}

	//--------------------

	public Salg(KurvInterface kurv) {
		this.kurv = kurv;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Salg{" + kurv + "} " + betalingsFormer;
	}
}
