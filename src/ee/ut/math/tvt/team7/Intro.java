package ee.ut.math.tvt.team7;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import ee.ut.math.tvt.team7.IntroUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Intro extends Application {
	public static String tiim;
	public static String liider;
	public static String liikmed;
	public static String meil;
	public static String logo;
	@Override
	public void start(Stage primaryStage) {
		
		Scene stseen =new Scene(IntroUI.toota(), 600, 400, Color.SNOW);
		primaryStage.setScene(stseen);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		OutputStream output = null;
	 
		try {
	 
			output = new FileOutputStream("application.properties");
	 
			// set the properties value
			prop.setProperty("tiiminimi", "Team 7");
			prop.setProperty("tiimilogo", "logo.jpg");
			prop.setProperty("liider", "Lauri Välja");
			prop.setProperty("liidriemail", "valja.lauri@gmail.com");
			prop.setProperty("liige1", "Lauri Välja \nKeili Pedel \nIngrid Sarap \nMeelis Sulg");
			
			// save properties to project root folder
			prop.store(output, null);
	 
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 
		}
		String result = "";
		Properties properties = new Properties();
		String propFileName = "application.properties";
 
		//InputStream inputStream = Intro.class.getClassLoader().getResourceAsStream(propFileName);
		InputStream is = null;
		try {
			is = new FileInputStream(propFileName);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		liider = properties.getProperty("liider");
		tiim = properties.getProperty("tiiminimi");
		liikmed = properties.getProperty("liige1");
		meil = properties.getProperty("liidriemail");
		logo = properties.getProperty("tiimilogo");
		System.out.println(properties.getProperty("tiimilogo"));
		launch(args);
	}
}