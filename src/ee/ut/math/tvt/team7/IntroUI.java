package ee.ut.math.tvt.team7;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IntroUI{


	public static Group toota(){
		Group lava = new Group();
        Text nimi =new Text(Intro.tiim);
        nimi.setLayoutX(20);
        nimi.setLayoutY(20);
        lava.getChildren().add(nimi);
        Text liider =new Text(Intro.liider);
        liider.setLayoutX(20);
        liider.setLayoutY(80);
        lava.getChildren().add(liider);
		return lava;

	}


}
