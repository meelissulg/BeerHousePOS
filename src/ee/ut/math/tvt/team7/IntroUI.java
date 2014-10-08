package ee.ut.math.tvt.team7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class IntroUI extends Application {

	@Override
	public void start(Stage primaryStage) {
		Stage lava = new Stage();
		BorderPane piir = new BorderPane();
		Scene stseen = new Scene(piir, 500, 600, Color.SNOW);
		lava.setScene(stseen);
		lava.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
