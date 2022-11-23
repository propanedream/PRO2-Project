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
import model.Produkt;
import model.ProduktInterface;

public class ProduktPane extends GridPane {
	private Produkt produkt;
	private ListView<ProduktInterface> lvwProdukts;
	private TextField txfProduktNavn, txfProduktPris;

	public ProduktPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		this.setStyle("-fx-background-color: darkgreen");
		this.setAlignment(Pos.CENTER);

		Label lblProdukts = new Label("Produkter");
		this.add(lblProdukts, 0, 0);
		GridPane.setHalignment(lblProdukts, HPos.CENTER);
		lblProdukts.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
		lvwProdukts = new ListView<>();
		this.add(lvwProdukts, 0, 1, 1, 3);
		lvwProdukts.setPrefWidth(250);
		lvwProdukts.setPrefHeight(150);
		lvwProdukts.getItems().setAll(Controller.getProdukts());
		ChangeListener<ProduktInterface> listener = (ov, oldProdukt, newProdukt) -> this.updateControlsProdukt();
		lvwProdukts.getSelectionModel().selectedItemProperty().addListener(listener);

		Button btnCreateProdukt = new Button("Opret produkt");
		this.add(btnCreateProdukt, 0, 4, 3, 1);
		GridPane.setHalignment(btnCreateProdukt, HPos.CENTER);
		btnCreateProdukt.setOnAction(event -> this.createActionProdukt());
	}

	// -------------------------------------------------------------------------

	private void createActionProdukt() {
		ProduktOpretVindue dia = new ProduktOpretVindue("Opret produkt", produkt);
		dia.showAndWait();
		// Wait for the modal dialog to close
		lvwProdukts.getItems().setAll(Controller.getProdukts());
		int index = lvwProdukts.getItems().size() - 1;
		lvwProdukts.getSelectionModel().select(index);
	}

	public void updateControlsProdukt() {
		ProduktInterface produkt = lvwProdukts.getSelectionModel().getSelectedItem();
		if (produkt != null) {
			txfProduktNavn.setText(""+produkt.getNavn());
		} else {
			txfProduktNavn.clear();
			txfProduktPris.clear();
		}
	}
}
