package ee.ut.math.tvt.team7;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IntroUI extends Application {

	@Override
	public void start(Stage primaryStage) {
		Group lava = new Group();
        Scene stseen = new Scene(lava, 600, 500, Color.SNOW);
        Text nimi =new Text("Team 7");
        nimi.setLayoutX(20);
        nimi.setLayoutY(20);
        lava.getChildren().add(nimi);
        Text liider =new Text("Lauri OUT");
        liider.setLayoutX(20);
        liider.setLayoutY(80);
        lava.getChildren().add(liider);
        primaryStage.setScene(stseen);
        primaryStage.setResizable(false);
        primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
