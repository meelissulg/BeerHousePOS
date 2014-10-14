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
	public static String revision;
	public static String minor;
	public static String major;
	@Override
	public void start(Stage primaryStage) {
		
		Scene stseen =new Scene(IntroUI.toota(), 600, 400, Color.SNOW);
		primaryStage.setScene(stseen);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		String nimi = "version.properties";
 
 		InputStream input = null;
		try {
			input= new FileInputStream(nimi);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		revision=prop.getProperty("build.revision.number");
		minor=prop.getProperty("build.minor.number");
		major=prop.getProperty("build.major.number");
		Properties propa = new Properties();
		OutputStream output = null;
	 
		try {
	 
			output = new FileOutputStream("version.properties");
	 
			// set the properties value
			int a=Integer.parseInt(prop.getProperty("build.revision.number"))+1;
			String b=Integer.toString(a);
			propa.setProperty("build.revision.number", b);
			propa.setProperty("build.minor.number", "1");
			propa.setProperty("build.major.number", "1");
			
			// save properties to project root folder
			propa.store(output, null);
	 
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
		launch(args);
	}
}