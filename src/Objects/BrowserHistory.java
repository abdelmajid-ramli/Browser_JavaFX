package Objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BrowserHistory {
	private String time;
	private String url;
	private String title;
	private String date;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void writeHistory(ArrayList<BrowserHistory> history) throws IOException {
		
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/ar/Desktop/history.txt"))) 
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
        
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:/Users/ar/Desktop/history.txt")));
	    
	    writer.append(contentBuilder);
	    for(BrowserHistory his:history) {
	    	if(his.getTitle().equals("")) {
	    		his.setTitle("URL");
	    	}
	    	String entry=his.getDate()+","+his.getTime()+","+his.getTitle()+","+his.getUrl()+";";
	    	writer.append(entry);
	    }
	    
	    writer.close();
	    

	}
	
	

}
