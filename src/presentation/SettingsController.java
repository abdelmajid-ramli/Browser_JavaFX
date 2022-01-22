package presentation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class SettingsController implements Initializable{
	
	@FXML private RadioButton rb_dark;
	@FXML private RadioButton rb_light;
	
	private ToggleGroup group = new ToggleGroup();
	
	public Scene scene;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		rb_dark.setToggleGroup(group);
		rb_light.setToggleGroup(group);
		rb_dark.setSelected(true);
	}
	
	public void set_scene(Scene primary_scene) {
		scene=primary_scene;
	}
	
	
	public void set_theme() {
		String str="";
		if(rb_dark.isSelected()) {
			str="dark";
		}
		
		if(rb_light.isSelected()) {
			str="light";
		}
		
		String filePath = new File("").getAbsolutePath();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource("/application/"+str+".css").toExternalForm());
		//scene.getStylesheets().add(filePath+"/src/application/"+str+".css");
		
		
	}
	
	public void delete_history() throws IOException {
		File file=new File("C:/Users/ar/Desktop/history.txt");
		file.delete();
		File file2=new File("C:/Users/ar/Desktop/history.txt");
        file2.createNewFile();
		
	}
	
	public void delete_favorits() throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        String filePath = new File("").getAbsolutePath();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath +"/src/index.html"))) 
        {
 
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) 
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        String str[]=String.valueOf(contentBuilder).split("<!--section--!>");
        str[0]+="<!--section--!>\n";
        str[0]+="\n<a href="+'"'+"#"+'"'+" class="+'"'+"content__fav"+'"'+">"+"add fav"+"</a>";
        str[0]+="\n<!--section--!>";
        str[1]="";
        
	    BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath +"/src/index.html")));
	    
	    for(String s:str) {
	    	writer.write(s);
	    }
	    
	    writer.close();
		
	}
	
	

}
