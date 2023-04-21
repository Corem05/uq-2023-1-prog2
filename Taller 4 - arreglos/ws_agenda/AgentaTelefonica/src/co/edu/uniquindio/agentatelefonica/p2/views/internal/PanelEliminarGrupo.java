package co.edu.uniquindio.agentatelefonica.p2.views.internal;

import co.edu.uniquindio.agentatelefonica.p2.controllers.CtrlGrupo;
import co.edu.uniquindio.agentatelefonica.p2.util.Boton;
import co.edu.uniquindio.agentatelefonica.p2.util.Utility;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PanelEliminarGrupo extends BorderPane {
	private EventHandler<? super MouseEvent> eventoVolver;

	public PanelEliminarGrupo(EventHandler<? super MouseEvent> eventoVolver) {
		this.eventoVolver = eventoVolver;
		initComponents();
	}

	private void initComponents() {

		TextField tfNombre = new TextField();

		VBox vbox = new VBox(20);
		HBox hbox = new HBox();
		Boton botonVolver = new Boton("Volver", eventoVolver, "btn-volver");
		Boton botonEliminar = new Boton("Agregar", e -> {
			CtrlGrupo.eliminarGrupo(tfNombre.getText());
		});

		vbox.setId("centered-box");

		vbox.getChildren().add(Utility.generarHBox("Escribe el nombre del grupo", tfNombre));
		hbox.getChildren().addAll(botonEliminar, botonVolver);

		HBox.setHgrow(botonEliminar, Priority.ALWAYS);
		HBox.setHgrow(botonVolver, Priority.ALWAYS);

		setCenter(vbox);
		setBottom(hbox);
	}

}
