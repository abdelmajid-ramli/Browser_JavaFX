package Objects;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import presentation.SettingsController;

public class AddTab {
	
    public Tab newTabButton(TabPane tabPane,Scene main_scene) {
        Tab addTab = new Tab("+");
        addTab.setClosable(false);
        
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if(newTab == addTab) {
            	Tab tab=new Tab("New Tab");
                tabPane.getTabs().add(tabPane.getTabs().size() - 1, tab); 
                tabPane.getSelectionModel().select(tabPane.getTabs().size() - 2); 
                
             // Create a WebView
                WebView browser = new WebView();
                
                // Get WebEngine via WebView
                WebEngine webEngine = browser.getEngine();
                
                ProgressBar progressBar = new ProgressBar();
                
                
                // A Worker load the page
                Worker<Void> worker = webEngine.getLoadWorker();

                
                VBox vb=new VBox();
                HBox hb=new HBox();
                
                hb.getStyleClass().add("hbox");
                
                //vb.getStyleClass().add("hbox");
                
                TextField tf_url =new TextField();
                
                Button btn_previous=new Button();
                Button btn_next=new Button();
                Button btn_reload=new Button();
                Button btn_home=new Button();
                Button btn_close=new Button();
                Button btn_fav=new Button();
                Button btn_downloads=new Button();
                Button btn_history=new Button();
                Button btn_print=new Button();
                Button btn_settings=new Button();
                
                Button btn_zoom_in=new Button();
                Button btn_zoom_out=new Button();
                
                Image img1 = new Image(getClass().getResourceAsStream("/imgs/navigate_before.png"));
                ImageView imgView1=new ImageView(img1);
                imgView1.setFitHeight(23);
                imgView1.setFitWidth(23);
                btn_previous.setGraphic(imgView1);
                btn_previous.setPrefSize(23, 23);
                
                Image img2 = new Image(getClass().getResourceAsStream("/imgs/navigate_next.png"));
                ImageView imgView2=new ImageView(img2);
                imgView2.setFitHeight(23);
                imgView2.setFitWidth(23);
                btn_next.setGraphic(imgView2);
                btn_next.setPrefSize(23, 23);
                
                Image img3 = new Image(getClass().getResourceAsStream("/imgs/reload.png"));
                ImageView imgView3=new ImageView(img3);
                imgView3.setFitHeight(23);
                imgView3.setFitWidth(23);
                btn_reload.setGraphic(imgView3);
                btn_reload.setPrefSize(23, 23);
                
                Image img = new Image(getClass().getResourceAsStream("/imgs/home.png"));
                ImageView imgView=new ImageView(img);
                imgView.setFitHeight(23);
                imgView.setFitWidth(23);
                btn_home.setGraphic(imgView);
                btn_home.setPrefSize(23, 23);
                
                Image img4 = new Image(getClass().getResourceAsStream("/imgs/zoom_out.png"));
                ImageView imgView4=new ImageView(img4);
                imgView4.setFitHeight(23);
                imgView4.setFitWidth(23);
                btn_zoom_out.setGraphic(imgView4);
                btn_zoom_out.setPrefSize(23, 23);
                
                Image img5 = new Image(getClass().getResourceAsStream("/imgs/zoom_in.png"));
                ImageView imgView5=new ImageView(img5);
                imgView5.setFitHeight(23);
                imgView5.setFitWidth(23);
                btn_zoom_in.setGraphic(imgView5);
                btn_zoom_in.setPrefSize(23, 23);
                
                Image img6 = new Image(getClass().getResourceAsStream("/imgs/history.png"));
                ImageView imgView6=new ImageView(img6);
                imgView6.setFitHeight(23);
                imgView6.setFitWidth(23);
                btn_history.setGraphic(imgView6);
                btn_history.setPrefSize(23, 23);
                
                Image img7 = new Image(getClass().getResourceAsStream("/imgs/printer.png"));
                ImageView imgView7=new ImageView(img7);
                imgView7.setFitHeight(23);
                imgView7.setFitWidth(23);
                btn_print.setGraphic(imgView7);
                btn_print.setPrefSize(23, 23);
                
                Image img8 = new Image(getClass().getResourceAsStream("/imgs/favorite.png"));
                ImageView imgView8=new ImageView(img8);
                imgView8.setFitHeight(23);
                imgView8.setFitWidth(23);
                btn_fav.setGraphic(imgView8);
                btn_fav.setPrefSize(23, 23);
                
                Image img9 = new Image(getClass().getResourceAsStream("/imgs/download.png"));
                ImageView imgView9=new ImageView(img9);
                imgView9.setFitHeight(23);
                imgView9.setFitWidth(23);
                btn_downloads.setGraphic(imgView9);
                btn_downloads.setPrefSize(23, 23);
                
                Image img10 = new Image(getClass().getResourceAsStream("/imgs/close.png"));
                ImageView imgView10=new ImageView(img10);
                imgView10.setFitHeight(23);
                imgView10.setFitWidth(23);
                btn_close.setGraphic(imgView10);
                btn_close.setPrefSize(23, 23);
                
                Image img11 = new Image(getClass().getResourceAsStream("/imgs/settings.png"));
                ImageView imgView11=new ImageView(img11);
                imgView11.setFitHeight(23);
                imgView11.setFitWidth(23);
                btn_settings.setGraphic(imgView11);
                btn_settings.setPrefSize(23, 23);
                 
                
                tf_url.setPrefWidth(800);
                progressBar.setPrefWidth(1400);
                progressBar.setPrefHeight(10);
                
                hb.getChildren().addAll(btn_previous,btn_next,btn_reload,btn_home,tf_url,btn_close,btn_zoom_out,btn_zoom_in,btn_fav,btn_downloads,btn_history,btn_print,btn_settings);
                hb.setPadding(new Insets(5));
                hb.setSpacing(8);
                
                vb.getChildren().add(hb);
                vb.getChildren().add(progressBar);
                vb.getChildren().add(browser);
                //vb.setSpacing(5);
                
                tab.setContent(vb);
                
                tf_url.setOnAction((event) -> {
                	webEngine.load("http://www."+tf_url.getText());
                	progressBar.setVisible(true);
                	});
                
                
                worker.stateProperty().addListener(new ChangeListener<State>() {

                    @Override
                    public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
                        if (newValue == Worker.State.SUCCEEDED) {
                        	progressBar.setVisible(false);
                        }
                    }
                });
                
                // Bind the progress property of ProgressBar
                // with progress property of Worker
                progressBar.progressProperty().bind(worker.progressProperty());
                
                
                progressBar.setVisible(false);
                
                
                btn_previous.setOnAction((event) -> {
                	WebHistory history=webEngine.getHistory();
                	ObservableList<WebHistory.Entry> entries=history.getEntries();
                	history.go(-1);
                	
                	tf_url.setText(entries.get(history.getCurrentIndex()).getUrl());
                });
                btn_next.setOnAction((event) -> {
                	WebHistory history=webEngine.getHistory();
                	history.go(1);
                	ObservableList<WebHistory.Entry> entries=history.getEntries();
                	tf_url.setText(entries.get(history.getCurrentIndex()).getUrl());
                });
                
                btn_print.setOnAction((event) -> {
                    PrinterJob job = PrinterJob.createPrinterJob();
                    if (job != null) {
                        webEngine.print(job);
                        job.endJob();
                    }
                });
                
                btn_zoom_in.setOnAction((event) -> {
                	browser.setZoom(browser.getZoom()+0.25);
                });
                
                btn_zoom_out.setOnAction((event) -> {
                	browser.setZoom(browser.getZoom()-0.25);
                });
                
                btn_home.setOnAction((event) -> {
                	URL url = this.getClass().getResource("/index.html");
                    webEngine.load(url.toString());
                    tf_url.setText("");
                });
                
                btn_close.setOnAction((event) -> {
                    webEngine.getLoadWorker().cancel();
                    
                    //progressBar.setVisible(false);
                });
                
                btn_history.setOnAction((event) -> {
            		//creating the new window
            		Stage primaryStage=new Stage();
            		FXMLLoader loader=new FXMLLoader();
            		Pane root = null;
					try {
						root = loader.load(getClass().getResource("/presentation/History.fxml").openStream());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		Scene scene = new Scene(root);
            		
            		scene.getStylesheets().add(getClass().getResource("/application/dark.css").toExternalForm());
            		primaryStage.setScene(scene);
            		primaryStage.show();
                }); 
                
                btn_settings.setOnAction((event) -> {
            		//creating the new window
            		Stage primaryStage=new Stage();
            		FXMLLoader loader=new FXMLLoader();
            		Pane root = null;
					try {
						root = loader.load(getClass().getResource("/presentation/Settings.fxml").openStream());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		Scene scene = new Scene(root);
            		
            		SettingsController control=(SettingsController)loader.getController();
            		control.set_scene(main_scene);
            		
            		scene.getStylesheets().add(getClass().getResource("/application/dark.css").toExternalForm());
            		primaryStage.setScene(scene);
            		primaryStage.show();
                });  
                
            	btn_fav.setOnAction((event) -> {
            		
                	WebHistory history=webEngine.getHistory();
                	ObservableList<WebHistory.Entry> entries=history.getEntries();
                	
                	WebHistory.Entry entry=entries.get(history.getCurrentIndex());
                	Favorite fav=new Favorite();
        			fav.setTitle(entry.getTitle());
        			fav.setUrl(entry.getUrl());
            		try {
						new Favorite().writeFav(fav);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            		//creating the new window
            		Stage primaryStage=new Stage();
            		FXMLLoader loader=new FXMLLoader();
            		Pane root = null;
					try {
						root = loader.load(getClass().getResource("/presentation/Favorite.fxml").openStream());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		Scene scene = new Scene(root);
            		
            		scene.getStylesheets().add(getClass().getResource("/application/dark.css").toExternalForm());
            		primaryStage.setScene(scene);
            		primaryStage.show();
                });
                
                
             // monitor the location url, and if it is a pdf file, then create a pdf viewer for it, if it is downloadable, then download it.
                browser.getEngine().locationProperty().addListener(new ChangeListener<String>() {
                  @Override public void changed(ObservableValue<? extends String> observableValue, String oldLoc, String newLoc) {
                    String downloadableExtension = null;  // todo I wonder how to find out from WebView which documents it could not process so that I could trigger a save as for them?
                    String[] downloadableExtensions = { ".doc", ".xls", ".zip", ".tgz", ".jar" };
                    for (String ext: downloadableExtensions) {
                      if (newLoc.endsWith(ext)) {
                        downloadableExtension = ext;
                        break;
                      }
                    }
                    if (downloadableExtension != null) {  
                      // create a file save option for performing a download.
                      FileChooser chooser = new FileChooser();
                      chooser.setTitle("Save " + newLoc);
                      chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Downloadable File", downloadableExtension));
                      int filenameIdx = newLoc.lastIndexOf("/") + 1;
                      if (filenameIdx != 0) {
                        File saveFile = chooser.showSaveDialog(browser.getScene().getWindow());

                        if (saveFile != null) {
                          BufferedInputStream  is = null;
                          BufferedOutputStream os = null;
                          try {
                            is = new BufferedInputStream(new URL(newLoc).openStream());
                            os = new BufferedOutputStream(new FileOutputStream(saveFile));
                            int b = is.read();
                            while (b != -1) {
                              os.write(b);
                              b = is.read();
                            }
                          } catch (FileNotFoundException e) {
                            System.out.println("Unable to save file: " + e);
                          } catch (MalformedURLException e) {
                            System.out.println("Unable to save file: " + e);
                          } catch (IOException e) {
                            System.out.println("Unable to save file: " + e);
                          } finally {
                            try { if (is != null) is.close(); } catch (IOException e) { /** no action required. */ }
                            try { if (os != null) os.close(); } catch (IOException e) { /** no action required. */ }
                          }
                        }
                           
                        // todo provide feedback on the save function and provide a download list and download list lookup.
                      }
                    }
                  }
                });
                
                
                
                btn_reload.setOnAction((event) -> {webEngine.reload();});
                
                URL url = this.getClass().getResource("/index.html");
                webEngine.load(url.toString());
                
            	tab.setOnClosed((event) -> {
            		ObservableList<WebHistory.Entry> history=webEngine.getHistory().getEntries();
            		ArrayList<BrowserHistory> browser_history=new ArrayList();
            		for(WebHistory.Entry entry:history) {
            			BrowserHistory his=new BrowserHistory();
            			String str;
            			if(entry.getLastVisitedDate().getMinutes()<10) {
            				 str="0"+entry.getLastVisitedDate().getMinutes();
            			}else {
            				 str=""+entry.getLastVisitedDate().getMinutes();
            			}
            			his.setTime(String.valueOf(entry.getLastVisitedDate().getHours()+":"+str));
            			his.setTitle(entry.getTitle());
            			his.setUrl(entry.getUrl());
            			his.setDate(String.valueOf(entry.getLastVisitedDate()));
            			browser_history.add(his);
            		}
            		try {
						new BrowserHistory().writeHistory(browser_history);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                });
            }
        });
        return addTab;
    }

}
