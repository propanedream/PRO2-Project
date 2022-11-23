package gui;

import controller.Controller;
import model.*;
import model.Produkt;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

//public class SalgPane extends GridPane {
//	private Produkt produkt;
//	private ListView<PrislisteInterface> lvwPrislistes;
//	private ListView<ProduktgruppeInterface> lvwProduktgruppes;
//	private ListView<ProduktInterface> lvwProdukts;
//	private ListView<KurvInterface> lvwKurvs;
//	private ListView<SalgInterface> lvwSalgs;
//	private TextField txfAntal, txfPris;

public class SalgPane extends GridPane {
    private Produkt produkt;
    private ListView<PrislisteInterface> lvwPrislistes;
    private ListView<ProduktgruppeInterface> lvwProduktgruppes;
    private ListView<ProduktInterface> lvwProdukts;
    private ListView<KurvInterface> lvwKurvs;
    private ListView<SalgInterface> lvwSalgs;
    private TextField txfAntal, txfPris;

    public SalgPane() {
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
        this.add(lvwPrislistes, 0, 1, 1, 2);
        lvwPrislistes.setPrefWidth(150);
        lvwPrislistes.setPrefHeight(100);
        lvwPrislistes.getItems().setAll(Controller.getPrislister());
        ChangeListener<PrislisteInterface> prislisteListener = (ov, oldPrisliste, newPrisliste) -> this.prislisteUpdateControls();
        lvwPrislistes.getSelectionModel().selectedItemProperty().addListener(prislisteListener);

        Button btnUpdatePrisliste = new Button("Opdater prislister");
        this.add(btnUpdatePrisliste, 0, 3);
        GridPane.setHalignment(btnUpdatePrisliste, HPos.CENTER);
        btnUpdatePrisliste.setOnAction(event -> this.opdaterActionPrisliste());

        Label lblProduktgruppes = new Label("Produktgrupper");
        this.add(lblProduktgruppes, 1, 0);
        GridPane.setHalignment(lblProduktgruppes, HPos.CENTER);
        lblProduktgruppes.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
        lvwProduktgruppes = new ListView<>();
        this.add(lvwProduktgruppes, 1, 1, 1, 2);
        lvwProduktgruppes.setPrefWidth(150);
        lvwProduktgruppes.setPrefHeight(100);
        ChangeListener<ProduktgruppeInterface> produktgruppeListener = (ov, oldProduktgruppe, newProduktgruppe) -> this.produktgruppeUpdateControls();
        lvwProduktgruppes.getSelectionModel().selectedItemProperty().addListener(produktgruppeListener);

        Button btnUpdateProduktgruppe = new Button("Opdater produktgrupper");
        this.add(btnUpdateProduktgruppe, 1, 3);
        GridPane.setHalignment(btnUpdateProduktgruppe, HPos.CENTER);
        btnUpdateProduktgruppe.setOnAction(event -> this.opdaterActionProduktgruppe());

        Label lblProdukts = new Label("Produkter");
        this.add(lblProdukts, 2, 0);
        GridPane.setHalignment(lblProdukts, HPos.CENTER);
        lblProdukts.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
        lvwProdukts = new ListView<>();
        this.add(lvwProdukts, 2, 1, 1, 2);
        lvwProdukts.setPrefWidth(150);
        lvwProdukts.setPrefHeight(100);

        Button btnUpdateProdukt = new Button("Opdater produkter");
        this.add(btnUpdateProdukt, 2, 3);
        GridPane.setHalignment(btnUpdateProdukt, HPos.CENTER);
        btnUpdateProdukt.setOnAction(event -> this.opdaterActionProdukt());

        Label lblAntal = new Label("Indtast antal af\ndet valgte produkt");
        this.add(lblAntal, 3, 1);
        GridPane.setHalignment(lblAntal, HPos.CENTER);
        lblAntal.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
        txfAntal = new TextField();
        this.add(txfAntal, 3, 2);
        GridPane.setHalignment(txfAntal, HPos.CENTER);
        txfAntal.setPrefWidth(50);

        Label lblKurv = new Label("Kurv");
        this.add(lblKurv, 4, 0);
        GridPane.setHalignment(lblKurv, HPos.CENTER);
        lblKurv.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
        lvwKurvs = new ListView<>();
        this.add(lvwKurvs, 4, 1, 1, 2);
        lvwKurvs.setPrefWidth(150);
        lvwKurvs.setPrefHeight(100);
        lvwKurvs.getItems().setAll(Controller.getKurvs());
        ChangeListener<KurvInterface> kurvListener = (ov, oldKurv, newKurv) -> this.kurvUpdateControls();
        lvwKurvs.getSelectionModel().selectedItemProperty().addListener(kurvListener);

        Button btnAddProduktToKurv = new Button("Tilføj produkt til kurv");
        this.add(btnAddProduktToKurv, 4, 3);
        GridPane.setHalignment(btnAddProduktToKurv, HPos.CENTER);
        btnAddProduktToKurv.setOnAction(event -> this.tilføjProduktTilKurvAction());

        Label lblPris = new Label("Samlet pris for\nden valgte kurv");
        this.add(lblPris, 5, 1);
        GridPane.setHalignment(lblPris, HPos.CENTER);
        lblPris.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
        txfPris = new TextField();
        this.add(txfPris, 5, 2);
        GridPane.setHalignment(txfPris, HPos.CENTER);
        txfPris.setPrefWidth(50);

        Button btnCreateSalg = new Button("Registrer salg");
        this.add(btnCreateSalg, 5, 3);
        GridPane.setHalignment(btnCreateSalg, HPos.CENTER);
        btnCreateSalg.setOnAction(event -> this.registrerSalg());

        Label lblSalg = new Label("Salg");
        this.add(lblSalg, 6, 0);
        GridPane.setHalignment(lblSalg, HPos.CENTER);
        lblSalg.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold");
        lvwSalgs = new ListView<>();
        this.add(lvwSalgs, 6, 1, 1, 2);
        lvwSalgs.setPrefWidth(150);
        lvwSalgs.setPrefHeight(100);
        lvwSalgs.getItems().setAll(Controller.getSalgs());
    }

    // -------------------------------------------------------------------------

    public void opdaterActionProdukt() {
        lvwProdukts.getItems().setAll(Controller.getProdukts());
    }

    public void opdaterActionProduktgruppe() {
        lvwProduktgruppes.getItems().setAll(Controller.getProduktgrupper());
    }

    public void opdaterActionPrisliste() {
        lvwPrislistes.getItems().setAll(Controller.getPrislister());
    }

    public void tilføjProduktTilKurvAction() {
        ProduktInterface produkt = lvwProdukts.getSelectionModel().getSelectedItem();
        KurvInterface kurv = lvwKurvs.getItems().get(0);
        String antal = txfAntal.getText().trim();
        Controller.addProduktToKurv(produkt, kurv, Integer.parseInt(antal));
        lvwKurvs.getItems().setAll(Controller.getKurvs());
//			txfPris.setText("" + kurv.samletPrisForKurv());
    }

    public void kurvUpdateControls() {
        KurvInterface kurv = lvwKurvs.getItems().get(0);
        if (kurv != null) {
//				txfPris.setText("" + kurv.samletPrisForKurv());
        } else {
            txfPris.clear();
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

    public void prislisteUpdateControls() {
        PrislisteInterface prisliste = lvwPrislistes.getSelectionModel().getSelectedItem();
        if (prisliste != null) {
            lvwProduktgruppes.getItems().setAll(prisliste.getProduktgrupper());
        } else {
            lvwProduktgruppes.getItems().clear();
        }
    }

    public void registrerSalg() {
        if (lvwKurvs.getItems().get(0).getProdukter().isEmpty()) {

            System.out.println("fejl");

        } else {
//            if (!lvwKurvs.getItems().get(0).getProdukter().isEmpty()) {

            //            }
            KurvInterface kurv = lvwKurvs.getItems().get(0);
            Controller.createSalg(kurv, null);

            Controller.removeKurv(kurv);
            Controller.createKurv();

            BetalingsFormer betalingsFormer = new BetalingsFormer("Betalingsform", null);
            betalingsFormer.showAndWait();
            lvwKurvs.getItems().setAll(Controller.getKurvs());
            lvwSalgs.getItems().setAll(Controller.getSalgs());
        }
    }
}


