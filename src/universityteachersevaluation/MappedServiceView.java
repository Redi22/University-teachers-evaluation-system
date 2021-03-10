/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.Service;
import Models.ServiceCategory;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author kk
 */

//GUI class to handle all the service CRUD
public class MappedServiceView {
    TextField searchField;
    StackPane mainPane;
    List<Service> services = null;
    ServiceCategory s = null;
    VBox mapsContainer;
    HBox labelHolder;
    SingleMappedServiceView singleView ;
    public ScrollPane mappedServices(ServiceCategory sc){
        s =sc;
        Pane pane = new Pane();
        mainPane = new StackPane(); 
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setPrefWidth(1200);
        VBox contentHolder =  new VBox();
        Pane content =  new Pane();
        
        searchField = new TextField();
        searchField.setPromptText("serach here");
        searchField.setPrefHeight(40.0);
        searchField.setPrefWidth(300.0);
        Label label5 = new Label();
        label5.setLayoutX(37.0);
        label5.setLayoutY(14.0);
        label5.setPrefHeight(34.0);
        label5.setPrefWidth(241.0);
        label5.setStyle("-fx-background-color: white;");
        label5.setText("Assign Service to Teacher");
        label5.setFont(new Font(16.0));

        TextField nameField =  new TextField();
        nameField.setLayoutX(37.0);
        nameField.setLayoutY(150.0); 
        nameField.setPrefHeight(40.0);
        nameField.setPrefWidth(300.0);
        nameField.setPromptText("Name");

        TextArea descriptionField = new TextArea();
        descriptionField.setLayoutX(37.0);
        descriptionField.setLayoutY(200.0);
        descriptionField.setPrefHeight(120.0);
        descriptionField.setPrefWidth(300.0);
        descriptionField.setPromptText("Description");
        Button addService = new Button();
        addService.setLayoutX(65.0); 
        addService.setLayoutY(280.0);
        addService.setMnemonicParsing(false);
        addService.setPrefHeight(35.0);
        addService.setPrefWidth(150.0);
        addService.setStyle("-fx-background-color: teal;");
        addService.setText("Register");
        addService.setTextFill(Color.valueOf("#fff8f8"));

        TextField percentileField =  new TextField();
        percentileField.setLayoutX(37.0);
        percentileField.setLayoutY(55.0);
        percentileField.setPrefHeight(40.0);
        percentileField.setPrefWidth(300.0);
        percentileField.setPromptText("Percentile");

       
 
        LevelOfEdCombo com = new LevelOfEdCombo();
        ComboBox levelOfEd = com.combo(); 

        levelOfEd.setLayoutX(37.0);
        levelOfEd.setLayoutY(200.0);
        levelOfEd.setPrefHeight(34.0);
        levelOfEd.setPrefWidth(200.0);
        levelOfEd.setPromptText("Level of Education");
        
        Button button4 = new Button();
        button4.setMnemonicParsing(false);
        button4.setLayoutY(400);
        button4.setLayoutX(120);
        button4.setPrefHeight(50.0);
        button4.setPrefWidth(50.0); 
        button4.setStyle("-fx-background-color: white;");
        FontAwesomeIcon cancelBtn = new FontAwesomeIcon();
        cancelBtn.setIconName("REMOVE"); 
        cancelBtn.setFill(Color.TEAL);

        button4.setGraphic(cancelBtn);
        button4.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
        button4.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(content);
                    }
                });
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#b2d8d8"));
        contentHolder.setEffect(dropShadow);
        contentHolder.setLayoutX(430.0);
        contentHolder.setLayoutY(130.0);
        contentHolder.setPrefHeight(400);
        contentHolder.setPrefWidth(300);
 
        mainPane.setAlignment(Pos.CENTER);
        HBox DialogTitleBar =  new HBox();
        DialogTitleBar.setAlignment(Pos.CENTER);
        contentHolder.setAlignment(Pos.CENTER);  
        DialogTitleBar.getChildren().addAll(label5, button4);
        contentHolder.getChildren().addAll(DialogTitleBar  ,nameField  ,descriptionField   ,percentileField , levelOfEd, addService);
        contentHolder.setSpacing(20); 
        contentHolder.setPadding(new Insets(20 , 20 ,30 , 20));
        contentHolder.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        
        AnchorPane overlayContainer =  new AnchorPane();
        overlayContainer.setStyle("-fx-background-color: teal;");
        overlayContainer.setOpacity(0.2);
        overlayContainer.setPrefHeight(700);
        overlayContainer.setPrefWidth(1350);
        content.getChildren().addAll(overlayContainer ,contentHolder);
  
        pane.setStyle("-fx-background-color: #e6f2f0");
        
        singleView = new SingleMappedServiceView();
        
        //populating label holder for custom data table/card
        labelHolder = new HBox();
        Label label1 =  new Label("Service title");       
        Label label2 =  new Label("Level of Education");
        Label label3 =  new Label("Percentile");
        Label label4 = new Label("Description");
        label2.setFont(new Font(16.0));
        label1.setFont(new Font(16.0));
        label3.setFont(new Font(16.0));
        label4.setFont(new Font(16.0));
        label4.setPrefWidth(400);
        label4.setStyle("-fx-font-weight: bold ");
        label1.setStyle("-fx-font-weight: bold ");
        label2.setStyle("-fx-font-weight: bold ");
        label3.setStyle("-fx-font-weight: bold ");
        labelHolder.getChildren().addAll(label1 , label2, label4 , label3);
        labelHolder.setSpacing(20);
        mapsContainer = new VBox();
        mapsContainer.getChildren().add(labelHolder);
        mapsContainer.setStyle("-fx-background-color: white");
        mapsContainer.setLayoutX(20);
        mapsContainer.setLayoutY(100);
        mapsContainer.setPadding(new Insets(20));
        
        
        
        
        
        HBox hBox0 = new HBox();
        hBox0.setLayoutX(20.0);
        hBox0.setLayoutY(20.0);
        hBox0.setSpacing(100.0);
        hBox0.setAlignment(Pos.CENTER);
        Label label6 = new Label();
        label6.setPrefHeight(40.0);
        label6.setStyle("-fx-font-size: 30;");
        label6.setText("Service - Level of Education");
        label6.setFont(new Font(16.0));
 
        Button addServiceDialBtn = new Button();
        addServiceDialBtn.setMnemonicParsing(false);
        addServiceDialBtn.setPrefHeight(25.0); 
        addServiceDialBtn.setPrefWidth(120.0);
        addServiceDialBtn.setStyle("-fx-background-color: teal;");
        addServiceDialBtn.setText("Map Service");
        addServiceDialBtn.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
        
        
        Button taskBtn = new Button();
        taskBtn.setMnemonicParsing(false);
        taskBtn.setPrefHeight(25.0);
        taskBtn.setPrefWidth(120.0);
        taskBtn.setStyle("-fx-background-color: teal;");
        taskBtn.setText("Assign");
        taskBtn.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
        
        //adding the dialog for the service mapper 
        addServiceDialBtn.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().add(content);
                    }
                });
        
        FontAwesomeIcon fontAwesomeIcon8 = new FontAwesomeIcon();
        fontAwesomeIcon8.setIconName("PLUS");
        fontAwesomeIcon8.setSize("1.6em"); 
        fontAwesomeIcon8.setFill(Color.WHITE);
        addServiceDialBtn.setGraphic(fontAwesomeIcon8);

        
        
        hBox0.getChildren().addAll(label6 ,searchField );
        hBox0.getChildren().add(addServiceDialBtn);
        pane.getChildren().addAll(mapsContainer, hBox0); 
        mainPane.getChildren().add(pane);
        ScrollPane mainView = new ScrollPane();
        mainView.setStyle("-fx-background-color: #e6f2f0");
        mainView.setContent(mainPane); 
        mainView.setPrefHeight(650);
        mainView.setPrefWidth(1200);
        
        
        
        //handler for sending post request to the server
        addService.setOnAction(event -> {
            String name = nameField.getText();
            String description = descriptionField.getText();
            double percentile = Double.parseDouble(percentileField.getText());
            int levelId = com.getLevel().getId();
            int service_categpry_id = sc.getId();
            Service service = new Service(name , percentile , description , levelId ,service_categpry_id);
             try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/addService");
                serv.addService(service);
                mainPane.getChildren().remove(content);
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        refresh();
        
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            refresh();
        
});
        
        return mainView;
    }
    
    //function for getting the data from the server
     public List<Service> getData(boolean search){
         
         
         List<Service> service = null;
        if(!search){
                try {
            System.out.println("abt to create service");
            DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getServices");
            System.out.println("reasult set abt to be here");
            service =   serv.getServices(s.getId());
            System.out.println("reasult set here");
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
                    mapsContainer.getChildren().clear();

                try {
                    DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/searchService");
                    System.out.println("reasult set abt to be here");
                    service =   serv.searchService(searchField.getText() , s.getId());
                    System.out.println("reasult set here");
                } catch (NotBoundException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return service;
        
    }
    
     //refreshing the whole page
    public void refresh(){
        services = null;
        boolean searched = false;
        if(searchField.getText() != null){
            searched = true;
        }
        services = getData(searched);
        mapsContainer.getChildren().add(labelHolder);
        for(Service service : services){
            HBox some = singleView.mappedServiceView(service , mainPane);
            some.setAlignment(Pos.CENTER);
            some.setLayoutX(200);
            some.setLayoutY(80);
            Separator border =  new Separator();
            border.setOrientation(Orientation.HORIZONTAL);
            mapsContainer.getChildren().addAll(some , border);
        }
    }
}
