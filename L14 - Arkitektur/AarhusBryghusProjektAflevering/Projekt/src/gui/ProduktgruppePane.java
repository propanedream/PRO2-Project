package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Produktgruppe;
import model.ProduktInterface;
import model.ProduktgruppeInterface;

public class ProduktgruppePane extends GridPane {
	private Produktgruppe produktgruppe;
	private ListView<ProduktgruppeInterface> lvwProduktgruppes;
	private ListView<ProduktInterface> lvwProdukts;
	private ListView<ProduktInterface> lvwAlleProdukts;

	public ProduktgruppePane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		this.setStyle("-fx-background-color: darkgreen");
		this.setAlignment(Pos.CENTER);

		Label lblProduktgruppes = new Label("Produktgrupper");
		this.add(lblProduktgruppes, 0, 0);
		GridPane.setHalignment(lblProduktgruppes, HPos.CENTER);
		lblProduktgruppes.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
		lvwProduktgruppes = new ListView<>();
		this.add(lvwProduktgruppes, 0, 1, 1, 3);
		lvwProduktgruppes.setPrefWidth(250);
		lvwProduktgruppes.setPrefHeight(150);
		lvwProduktgruppes.getItems().setAll(Controller.getProduktgrupper());
		ChangeListener<ProduktgruppeInterface> listener = (ov, oldProduktgruppe, newProduktgruppe) -> this.updateControlsProduktgruppe();
		lvwProduktgruppes.getSelectionModel().selectedItemProperty().addListener(listener);

		Button btnCreateProduktgruppe = new Button("Opret produktgruppe");
		this.add(btnCreateProduktgruppe, 0, 4, 1, 1);
		GridPane.setHalignment(btnCreateProduktgruppe, HPos.CENTER);
		btnCreateProduktgruppe.setOnAction(event -> this.createActionProduktgruppe());

		Label lblProdukts = new Label("Produkter i den valgte produktgruppe");
		this.add(lblProdukts, 1, 0);
		GridPane.setHalignment(lblProdukts, HPos.CENTER);
		lblProdukts.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
		lvwProdukts = new ListView<>();
		this.add(lvwProdukts, 1, 1, 1, 3);
		lvwProdukts.setPrefWidth(250);
		lvwProdukts.setPrefHeight(150);

		Label lblAlleProdukts = new Label("AlleProdukter");
		this.add(lblAlleProdukts, 2, 0);
		GridPane.setHalignment(lblAlleProdukts, HPos.CENTER);
		lblAlleProdukts.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
		lvwAlleProdukts = new ListView<>();
		this.add(lvwAlleProdukts, 2, 1, 1, 3);
		lvwAlleProdukts.setPrefWidth(250);
		lvwAlleProdukts.setPrefHeight(150);
		lvwAlleProdukts.getItems().setAll(Controller.getProdukts());

		Button btnAddProduktToProduktgruppe = new Button("Tilføj produkt til produktgruppe");
		this.add(btnAddProduktToProduktgruppe, 2, 4, 1, 1);
		GridPane.setHalignment(btnAddProduktToProduktgruppe, HPos.CENTER);
		btnAddProduktToProduktgruppe.setOnAction(event -> this.tilføjProduktTilProduktgruppeAction());
	}

	// -------------------------------------------------------------------------

	private void createActionProduktgruppe() {
		ProduktgruppeOpretVindue dia = new ProduktgruppeOpretVindue("Opret produktgruppe", produktgruppe);
		dia.showAndWait();
		// Wait for the modal dialog to close
		lvwProduktgruppes.getItems().setAll(Controller.getProduktgrupper());
		int index = lvwProduktgruppes.getItems().size() - 1;
		lvwProduktgruppes.getSelectionModel().select(index);
	}

	public void updateControlsProduktgruppe() {
		ProduktgruppeInterface produktgruppe = lvwProduktgruppes.getSelectionModel().getSelectedItem();
		if (produktgruppe != null) {
			lvwProdukts.getItems().setAll(produktgruppe.getProdukter());
		} else {
			lvwProdukts.getItems().clear();
		}
	}

	public void tilføjProduktTilProduktgruppeAction() {
		ProduktInterface produkt = lvwAlleProdukts.getSelectionModel().getSelectedItem();
		ProduktgruppeInterface produktgruppe = lvwProduktgruppes.getSelectionModel().getSelectedItem();
		Controller.addProduktToProduktgruppe(produkt, produktgruppe);
		lvwProdukts.getItems().setAll(produktgruppe.getProdukter());
	}
}
