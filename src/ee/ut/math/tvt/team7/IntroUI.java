package ee.ut.math.tvt.team7;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IntroUI{


	public static Group toota(){
		Group lava = new Group();
		
        Text nimi =new Text(Intro.tiim);
        nimi.setFont(Font.font ("Verdana", 30));
        nimi.setLayoutX(20);
        nimi.setLayoutY(30);
        lava.getChildren().add(nimi);
        
        Text liider1 =new Text("Team leader:");
        liider1.setFont(Font.font ("Verdana", 16));
        liider1.setLayoutX(20);
        liider1.setLayoutY(100);
        lava.getChildren().add(liider1);
        
        Text liider =new Text(Intro.liider);
        liider.setLayoutX(20);
        liider.setLayoutY(120);
        lava.getChildren().add(liider);
        
        Text email1 =new Text("Team leader's e-mail:");
        email1.setFont(Font.font ("Verdana", 13));
        email1.setLayoutX(20);
        email1.setLayoutY(150);
        lava.getChildren().add(email1);
        
        Text email =new Text(Intro.meil);
        email.setLayoutX(20);
        email.setLayoutY(170);
        lava.getChildren().add(email);
        
        Text liikmed1 =new Text("Team members:");
        liikmed1.setFont(Font.font ("Verdana", 13));
        liikmed1.setLayoutX(20);
        liikmed1.setLayoutY(200);
        lava.getChildren().add(liikmed1);
        
        Text liikmed =new Text(Intro.liikmed);
        liikmed.setLayoutX(20);
        liikmed.setLayoutY(220);
        lava.getChildren().add(liikmed);
        
        Text versioon=new Text(Intro.major+"."+Intro.minor+"."+Intro.revision);
        versioon.setLayoutX(20);
        versioon.setLayoutY(400);
        lava.getChildren().add(versioon);
        
        Image logo = new Image(Intro.logo, 300, 300, true, true);
        ImageView iv= new ImageView(logo);
        iv.setLayoutX(350);
        iv.setLayoutY(20);
        lava.getChildren().add(iv);
        
		return lava;

	}


}
