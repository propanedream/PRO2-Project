package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.PrislisteInterface;
import model.ProduktInterface;
import model.ProduktgruppeInterface;

public class OpdaterPrislistePane extends GridPane {
	private PrislisteInterface prisliste;
	private ListView<PrislisteInterface> lvwPrislistes;
	private ListView<ProduktgruppeInterface> lvwProduktgruppes;
	private ListView<ProduktInterface> lvwProdukts;
	private TextField txfPris;

	public OpdaterPrislistePane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		this.setStyle("-fx-background-color: darkgreen");
		this.setAlignment(Pos.CENTER);

		Label lblPrislistes = new Label("Prislister");
		this.add(lblPrislistes, 0, 0);
		GridPane.setHalignment(lblPrislistes, HPos.CENTER);
		lblPrislistes.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
		lvwPrislistes = new ListView<>();
		this.add(lvwPrislistes, 0, 1, 1, 3);
		lvwPrislistes.setPrefWidth(250);
		lvwPrislistes.setPrefHeight(150);
		lvwPrislistes.getItems().setAll(Controller.getPrislister());
		ChangeListener<PrislisteInterface> listener = (ov, oldPrisliste, newPrisliste) -> this.updateControlsPrisliste();
		lvwPrislistes.getSelectionModel().selectedItemProperty().addListener(listener);

		Button btnCreatePrisliste = new Button("Opret prisliste");
		this.add(btnCreatePrisliste, 0, 4, 1, 1);
		GridPane.setHalignment(btnCreatePrisliste, HPos.CENTER);
		btnCreatePrisliste.setOnAction(event -> this.createActionPrisliste());

		Label lblProduktgruppes = new Label("Produktgruppeer i den valgte prisliste");
		this.add(lblProduktgruppes, 1, 0);
		GridPane.setHalignment(lblProduktgruppes, HPos.CENTER);
		lblProduktgruppes.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
		lvwProduktgruppes = new ListView<>();
		this.add(lvwProduktgruppes, 1, 1, 1, 3);
		lvwProduktgruppes.setPrefWidth(250);
		lvwProduktgruppes.setPrefHeight(150);
		ChangeListener<ProduktgruppeInterface> produktgruppeListener = (ov, oldProduktgruppe, newProduktgruppe) -> this.produktgruppeUpdateControls();
		lvwProduktgruppes.getSelectionModel().selectedItemProperty().addListener(produktgruppeListener);

		Label lblAlleProduktgruppes = new Label("Produkter i den valgte produktgruppe");
		this.add(lblAlleProduktgruppes, 2, 0);
		GridPane.setHalignment(lblAlleProduktgruppes, HPos.CENTER);
		lblAlleProduktgruppes.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
		lvwProdukts = new ListView<>();
		this.add(lvwProdukts, 2, 1, 1, 3);
		lvwProdukts.setPrefWidth(250);
		lvwProdukts.setPrefHeight(150);

		Label lblPris = new Label("Indtast ny pris");
		this.add(lblPris, 2, 4);
		GridPane.setHalignment(lblPris, HPos.CENTER);
		lblPris.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
		txfPris = new TextField();
		this.add(txfPris, 2, 5);
		GridPane.setHalignment(txfPris, HPos.CENTER);
		txfPris.setPrefWidth(50);

		Button btnOpdaterPris = new Button("Opdatér pris på det valgte produkt");
		this.add(btnOpdaterPris, 2, 6, 1, 1);
		GridPane.setHalignment(btnOpdaterPris, HPos.CENTER);
		btnOpdaterPris.setOnAction(event -> this.opdaterPrisAction());
	}

	// -------------------------------------------------------------------------

	private void createActionPrisliste() {
		PrislisteOpretVindue dia = new PrislisteOpretVindue("Opret prisliste", prisliste);
		dia.showAndWait();
		// Wait for the modal dialog to close
		lvwPrislistes.getItems().setAll(Controller.getPrislister());
		int index = lvwPrislistes.getItems().size() - 1;
		lvwPrislistes.getSelectionModel().select(index);
	}

	public void updateControlsPrisliste() {
		PrislisteInterface prisliste = lvwPrislistes.getSelectionModel().getSelectedItem();
		if (prisliste != null) {
			lvwProduktgruppes.getItems().setAll(prisliste.getProduktgrupper());
		} else {
			lvwProduktgruppes.getItems().clear();
		}
	}

	public void produktgruppeUpdateControls() {
		ProduktgruppeInterface produktgruppe = lvwProduktgruppes.getSelectionModel().getSelectedItem();
		if (produktgruppe != null) {
			lvwProdukts.getItems().setAll(produktgruppe.getProdukter());
		} else {
			lvwProdukts.getItems().clear();
		}
	}

	public void opdaterPrisAction() {
		PrislisteInterface prisliste = lvwPrislistes.getSelectionModel().getSelectedItem();
		ProduktgruppeInterface produktgruppe = lvwProduktgruppes.getSelectionModel().getSelectedItem();
		ProduktInterface produkt = lvwProdukts.getSelectionModel().getSelectedItem();
		double pris = Double.parseDouble(txfPris.getText().trim());
		//tilføjer elementer i arrayet svarende til antallet af prislister
		if (produkt.getPriss().isEmpty()) {
			for (int i = 0; i < lvwPrislistes.getItems().size(); i++) {
				produkt.addPris(0.0);
			}
		}
		//setter pris på indekset i arrayet svarende til indekset i den valgte prisliste
		if (prisliste.equals(lvwPrislistes.getItems().get(0))) {
			produkt.setPris(0, pris);
		} else if (prisliste.equals(lvwPrislistes.getItems().get(1))) {
			produkt.setPris(1, pris);
		} else if (prisliste.equals(lvwPrislistes.getItems().get(2))) {
			produkt.setPris(2, pris);
		}
		//opdaterer produktlisten med de nye værdier
		lvwProdukts.getItems().setAll(produktgruppe.getProdukter());
	}
}
