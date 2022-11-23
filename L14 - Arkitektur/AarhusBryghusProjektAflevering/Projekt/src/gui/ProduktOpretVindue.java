package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Produkt;

public class ProduktOpretVindue extends Stage {
	private Produkt produkt;

	// -------------------------------------------------------------------------
	private TextField txfNavn, txfPris;

	public ProduktOpretVindue(String title, Produkt produkt) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.produkt = produkt;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblId = new Label("Navn:");
		pane.add(lblId, 0, 0);
		txfNavn = new TextField();
		pane.add(txfNavn, 1, 0);
		txfNavn.setPrefWidth(200);

		Label lblNavn = new Label("Pris:");
		pane.add(lblNavn, 0, 1);
		txfPris = new TextField();
		pane.add(txfPris, 1, 1);
		txfPris.setPrefWidth(200);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 2);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 1, 2);
		btnOK.setOnAction(event -> this.okAction());

		this.initControls();
	}

	// -------------------------------------------------------------------------

	private void initControls() {
		if (produkt != null) {
			txfNavn.setText(""+produkt.getNavn());
		} else {
			txfNavn.clear();
			txfPris.clear();
		}
	}

	private void okAction() {
		String navn = txfNavn.getText().trim();
		String pris = txfPris.getText().trim();
		if (produkt != null) {
//			Controller.updateProdukt(produkt, navn, Double.parseDouble(pris));
		} else {
			Controller.createProdukt(navn);
		}
		this.hide();
	}

	private void cancelAction() {
		this.hide();
	}
}