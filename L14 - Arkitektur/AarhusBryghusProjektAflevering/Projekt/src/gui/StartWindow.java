package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class StartWindow extends Application {

	@Override
	public void init() {
		Controller.init();
	}

	@Override
	public void start(Stage stage) throws FileNotFoundException {
		stage.setTitle("KasseApparatSystem");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) throws FileNotFoundException {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) throws FileNotFoundException {
		tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

		Tab tabAdmin = new Tab("Velkomstside");
		tabPane.getTabs().add(tabAdmin);

		FrontpagePane adminPane = new FrontpagePane();
		tabAdmin.setContent(adminPane);

		Tab tabSalg = new Tab("Registrér salg");
		tabPane.getTabs().add(tabSalg);

		SalgPane SalgPane = new SalgPane();
		tabSalg.setContent(SalgPane);

		Tab tabProdukt = new Tab("Opret Produkt");
		tabPane.getTabs().add(tabProdukt);

		ProduktPane ProduktPane = new ProduktPane();
		tabProdukt.setContent(ProduktPane);

		Tab tabProduktgruppe = new Tab("Opret Produktgruppe");
		tabPane.getTabs().add(tabProduktgruppe);

		ProduktgruppePane ProduktgruppePane = new ProduktgruppePane();
		tabProduktgruppe.setContent(ProduktgruppePane);

		Tab tabOpretPrisliste = new Tab("Opret Prisliste");
		tabPane.getTabs().add(tabOpretPrisliste);

		OpretPrislistePane opretPrislistePane = new OpretPrislistePane();
		tabOpretPrisliste.setContent(opretPrislistePane);

		Tab tabOpdatérPrislister = new Tab("Opdatér prislister");
		tabPane.getTabs().add(tabOpdatérPrislister);

		OpdaterPrislistePane opdaterPrislistePane = new OpdaterPrislistePane();
		tabOpdatérPrislister.setContent(opdaterPrislistePane);
	}

}
