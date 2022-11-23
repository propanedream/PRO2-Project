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
import model.PrislisteInterface;
import model.ProduktgruppeInterface;

public class OpretPrislistePane extends GridPane {
	private PrislisteInterface prisliste;
	private ListView<PrislisteInterface> lvwPrislistes;
	private ListView<ProduktgruppeInterface> lvwProduktgruppes;
	private ListView<ProduktgruppeInterface> lvwAlleProduktgruppes;

	public OpretPrislistePane() {
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

		Label lblAlleProduktgruppes = new Label("Alle produktgrupper");
		this.add(lblAlleProduktgruppes, 2, 0);
		GridPane.setHalignment(lblAlleProduktgruppes, HPos.CENTER);
		lblAlleProduktgruppes.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
		lvwAlleProduktgruppes = new ListView<>();
		this.add(lvwAlleProduktgruppes, 2, 1, 1, 3);
		lvwAlleProduktgruppes.setPrefWidth(250);
		lvwAlleProduktgruppes.setPrefHeight(150);
		lvwAlleProduktgruppes.getItems().setAll(Controller.getProduktgrupper());

		Button btnAddProduktgruppeToPrisliste = new Button("Tilføj produktgruppe til prisliste");
		this.add(btnAddProduktgruppeToPrisliste, 2, 4, 1, 1);
		GridPane.setHalignment(btnAddProduktgruppeToPrisliste, HPos.CENTER);
		btnAddProduktgruppeToPrisliste.setOnAction(event -> this.tilføjProduktgruppeTilPrislisteAction());
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

	public void tilføjProduktgruppeTilPrislisteAction() {
		ProduktgruppeInterface produktgruppe = lvwAlleProduktgruppes.getSelectionModel().getSelectedItem();
		PrislisteInterface prisliste = lvwPrislistes.getSelectionModel().getSelectedItem();
		Controller.addProduktgruppeToPrisliste(produktgruppe, prisliste);
		lvwProduktgruppes.getItems().setAll(prisliste.getProduktgrupper());
	}
}
