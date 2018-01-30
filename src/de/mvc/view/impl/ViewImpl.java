package de.mvc.view.impl;

import de.mvc.view.View;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewImpl extends Application implements View {

	@Override
	public void start(Stage arg0) throws Exception {
		BorderPane root = new BorderPane();

		HBox hBox = new HBox();

		ListView<String> lw = new ListView<String>();
		ObservableList<String> ol = FXCollections.observableArrayList();
		lw.setItems(ol);

		Button b1 = new Button("Show articles");
		Button b2 = new Button("Weiter");
		root.setCenter(lw);

		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (ol.size() > 0) {
					ol.remove(0);
				}
				ol.add("test");

			}
		});

		hBox.getChildren().add(b1);
		hBox.getChildren().add(b2);

		root.setBottom(hBox);

		arg0.setScene(new Scene(root, 500, 500));
		arg0.show();
	}

}
