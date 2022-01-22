package presentation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Objects.BrowserHistory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class HistoryController implements Initializable{
	
	@FXML private ScrollPane history_pane;
	//@FXML private AnchorPane history_anchor;
	@FXML private VBox history_vbox;
	
	public ArrayList<BrowserHistory> history;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		add_item();
	}
	
	
	public void add_item() {
		
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/ar/Desktop/history.txt"))) 
        {
 
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) 
            {
                contentBuilder.append(sCurrentLine);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        String entries[]=contentBuilder.toString().split(";");
		for(String str:entries) {
			String his[]=str.split(",");
			HBox hbox = new HBox();
			
			String date2[]=his[0].split(" ");
			
			Label date=new Label(date2[1]+" "+date2[2]);
			Label time=new Label(his[1]);
			Label title=new Label(his[2]);
			Label url=new Label(his[3]);
			
			date.setPrefSize(80,50);
			time.setPrefSize(80,50);
			title.setPrefSize(80,50);
			url.setPrefSize(300,50);
			
			date.setTextFill(Color.WHITE);
			time.setTextFill(Color.WHITE);
			title.setTextFill(Color.WHITE);
			url.setTextFill(Color.WHITE);
			
			hbox.getChildren().addAll(date,time,title,url);
			hbox.setSpacing(20);
			history_vbox.getChildren().add(hbox);
		}
		
	}

}
