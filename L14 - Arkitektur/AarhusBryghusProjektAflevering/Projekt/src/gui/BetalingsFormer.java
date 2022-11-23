package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.BetalingsformerEnum;
import model.Kurv;
import model.KurvInterface;
import model.Salg;

import java.time.LocalDate;

public class BetalingsFormer extends Stage {
    private final Kurv kurv; // nullable


    public BetalingsFormer(String title, Kurv kurv) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.kurv = kurv;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------
    private final CheckBox chkbKredit = new CheckBox();
    private final CheckBox chkbKontant = new CheckBox();
    private final CheckBox chkbKlip = new CheckBox();

    private final TextField txtKredit = new TextField();
    private final TextField txtKontant = new TextField();
    private final TextField txtKlip = new TextField();

//------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        pane.setMinHeight(200);
        pane.setMinWidth(200);
//------------------------------------------------------------------
        Label lblKredit = new Label("Kreditkort: ");
        pane.add(lblKredit, 0, 0);
        pane.add(chkbKredit, 1, 0);
        pane.add(txtKredit, 2, 0);

        Label lblKontant = new Label("Kontant: ");
        pane.add(lblKontant, 0, 2);
        pane.add(chkbKontant, 1, 2);
        pane.add(txtKontant, 2, 2);

        Label lblKlip = new Label("Klippekort: ");
        pane.add(lblKlip, 0, 4);
        pane.add(chkbKlip, 1, 4);
        pane.add(txtKlip, 2, 4);

//------------------------------------------------------------------
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 15);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 5, 15);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());
//------------------------------------------------------------------


//        this.initControls();
    }

    // -------------------------------------------------------------------------

//    private void initControls() {
//        if (konference != null) {
//            txfNavn.setText(konference.getNavn());
//            txfAdresse.setText("" + konference.getAdresse());
//            txfPrisPrDag.setText("" + konference.getPrisPrDag());
//            txfAntalForedrag.setText("" + konference.getAntalForedrag());
//        } else {
//            txfNavn.clear();
//            txfAntalForedrag.clear();
//            txfPrisPrDag.clear();
//            txfAdresse.clear();
//        }
//    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {

        if (chkbKredit.isSelected()) {
            int antal = Integer.parseInt(txtKredit.getText());
            Salg salg = (Salg) Controller.getSalgs().get(Controller.getSalgs().size()-1);
            Controller.addBetalingsFormTilSalg(salg, BetalingsformerEnum.KREDITKORT, antal);
        }

        if (chkbKontant.isSelected()) {
            int antal = Integer.parseInt(txtKontant.getText());
            Salg salg = (Salg) Controller.getSalgs().get(Controller.getSalgs().size()-1);
            Controller.addBetalingsFormTilSalg(salg, BetalingsformerEnum.KONTANT, antal);
        }

        if (chkbKlip.isSelected()) {
            int antal = Integer.parseInt(txtKlip.getText());
            Salg salg = (Salg) Controller.getSalgs().get(Controller.getSalgs().size()-1);
            Controller.addBetalingsFormTilSalg(salg, BetalingsformerEnum.KLIPPEKORT, antal);
        }


        this.hide();
    }

//    private void okAction() {
//        String name = txfNavn.getText().trim();
//        if (name.length() == 0) {
//            lblError.setText("Navnefeltet er tomt");
//            return;
//        }
//        String addresse = txfAdresse.getText().trim();
//        if (addresse.length() == 0) {
//            lblError.setText("Adressefeltet er tomt");
//            return;
//        }
//
//        LocalDate startDato1 = startDato.getValue();
//        LocalDate slutDato1 = slutDato.getValue();
//
//
//        int pris = -1;
//        try {
//            pris = Integer.parseInt(txfPrisPrDag.getText().trim());
//        } catch (NumberFormatException ex) {
//            // do nothing
//        }
//        if (pris < 0) {
//            lblError.setText("Prisen er forkert");
//            return;}
//
//        int antalForedrag = -1;
//        try {
//            antalForedrag = Integer.parseInt(txfPrisPrDag.getText().trim());
//        } catch (NumberFormatException ex) {
//            // do nothing
//        }
//        if (antalForedrag < 0) {
//            lblError.setText("Antal foredrag er forkert");
//            return;
//
//        }
//
//
//
////        Controller.createKonference(name, addresse, antalForedrag, pris, startDato1,slutDato1);
//
//        this.hide();
//
//    }
}