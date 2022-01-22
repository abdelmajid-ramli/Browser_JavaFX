package application;
	
import java.io.File;
import java.io.IOException;

import Objects.AddTab;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;


public class Main extends Application {
	Scene scene;
	
	public void load_page() {
		
	}
	
	@Override
	public void start(Stage stage) throws IOException {
        TabPane tabPane = new TabPane();


        scene=new Scene(tabPane);
        scene.getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
        
        stage.setScene(scene);
        tabPane.getTabs().add(new AddTab().newTabButton(tabPane,scene));
        stage.setMaximized(true);
        stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
