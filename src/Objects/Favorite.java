package Objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Favorite {
	private String url;
	private String title;
	
	
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
	
public void writeFav(Favorite fav) throws IOException {
		
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
        String str1[]=fav.getUrl().split("/.");
        System.out.println(fav.getUrl());
        System.out.println(str[1]);
        str[0]+="<!--section--!>\n";
        str[1]+="\n<a href="+'"'+fav.getUrl()+'"'+" class="+'"'+"content__fav"+'"'+">"+str1[1]+"</a>";
        System.out.println(str[1]);
        str[1]+="\n<!--section--!>";
        
	    BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath +"/src/index.html")));
	    
	    for(String s:str) {
	    	writer.write(s);
	    }
	    
	    writer.close();
	
}
	
	

}
