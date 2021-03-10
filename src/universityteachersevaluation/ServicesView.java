/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.Service;
import Models.ServiceCategory;
import Models.Teacher;
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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
import static universityteachersevaluation.UniversityTeachersEvaluation.currentUser;

/**
 *
 * @author kk
 */

//GUI controller class for services view 
public class ServicesView {
    VBox serviceHolder;
    TextField searchField;
    List<ServiceCategory> serviceCategories = null;
    StackPane mainPane;
    public ScrollPane servicesView(){
        ScrollPane mainView = new ScrollPane();
    mainPane =  new StackPane();
    mainPane.setAlignment(Pos.CENTER);
    mainPane.setPrefWidth(1200);

    
        searchField = new TextField();
        searchField.setPromptText("serach here");
        searchField.setPrefHeight(40.0);
        searchField.setPrefWidth(300.0);
        
        
        Pane pane =  new Pane();

        
        VBox contentHolder =  new VBox();
            
        Pane content =  new Pane();
          
        Label label3 = new Label();
        label3.setLayoutX(37.0);
        label3.setLayoutY(14.0);
        label3.setPrefHeight(34.0);
        label3.setPrefWidth(241.0);
        label3.setStyle("-fx-background-color: white;");
        label3.setText("Service Category Registration");
        label3.setFont(new Font(16.0));

        TextField nameField =  new TextField();
        nameField.setLayoutX(37.0);
        nameField.setLayoutY(55.0);
        nameField.setPrefHeight(34.0);
        nameField.setPrefWidth(200.0);
        nameField.setPromptText("Name");
 
      
        Button addCategoryBtn = new Button();
        addCategoryBtn.setLayoutX(65.0);
        addCategoryBtn.setLayoutY(280.0);
        addCategoryBtn.setMnemonicParsing(false);
//        makeAdmin.setOnAction(this::makeAdmin);
        addCategoryBtn.setPrefHeight(35.0);
        addCategoryBtn.setPrefWidth(150.0);
        addCategoryBtn.setStyle("-fx-background-color: teal;");
        addCategoryBtn.setText("Register");
        addCategoryBtn.setTextFill(Color.valueOf("#fff8f8"));

        TextArea descriptionField =  new TextArea();
        descriptionField.setLayoutX(37.0);
        descriptionField.setLayoutY(150.0);
        descriptionField.setPrefHeight(160.0);
        descriptionField.setPrefWidth(200.0);
        descriptionField.setPromptText("description");

       
  
        Button removerBtn = new Button();
        removerBtn.setMnemonicParsing(false);
        removerBtn.setLayoutY(400);
        removerBtn.setLayoutX(120);
        removerBtn.setPrefHeight(50.0);
        removerBtn.setPrefWidth(50.0); 
        removerBtn.setStyle("-fx-background-color: white;");
        FontAwesomeIcon cancelBtn = new FontAwesomeIcon();
        cancelBtn.setIconName("REMOVE"); 
        cancelBtn.setFill(Color.TEAL);

        removerBtn.setGraphic(cancelBtn);
        removerBtn.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
        
        //removing the dialog handler
        removerBtn.setOnAction(
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
       DialogTitleBar.getChildren().addAll(label3, removerBtn);
        contentHolder.getChildren().addAll(DialogTitleBar, nameField  , descriptionField , addCategoryBtn);
        
        contentHolder.setSpacing(20); 
        contentHolder.setPadding(new Insets(20 , 20 ,0 , 20));
        contentHolder.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        
        AnchorPane overlayContainer =  new AnchorPane();
        overlayContainer.setStyle("-fx-background-color: teal;");
        overlayContainer.setOpacity(0.2);
        overlayContainer.setPrefHeight(700);
        overlayContainer.setPrefWidth(1350);
        content.getChildren().addAll(overlayContainer ,contentHolder);

        HBox hBox0 = new HBox();

        hBox0.setSpacing(200.0);
        hBox0.setAlignment(Pos.CENTER);
        Label label5 = new Label();
        label5.setPrefHeight(40.0);
        label5.setStyle("-fx-font-size: 30;");
        label5.setText("Services View");
        label5.setFont(new Font(16.0));

        Button addServiceDialBtn = new Button();
        addServiceDialBtn.setMnemonicParsing(false);
        addServiceDialBtn.setPrefHeight(25.0);
        addServiceDialBtn.setPrefWidth(120.0);
        addServiceDialBtn.setStyle("-fx-background-color: teal;");
        addServiceDialBtn.setText("Add Service");
        addServiceDialBtn.setTextFill(Color.valueOf("#fff8f8"));
        
         
        
        //adding the dialog
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

        
        hBox0.getChildren().addAll(label5 ,searchField);
        if(UniversityTeachersEvaluation.currentUser.getUser().isAdmin()){
            hBox0.getChildren().add(addServiceDialBtn);
        }
        serviceHolder =  new VBox();   
        serviceHolder.setLayoutX(50);
        serviceHolder.setLayoutY(70);
        serviceHolder.setSpacing(20);
        
       
        pane.getChildren().add(hBox0);
        
        pane.getChildren().addAll(serviceHolder);
        pane.setStyle("-fx-background-color: #e6f2f0");
        mainPane.getChildren().add(pane);
        mainView.setStyle("-fx-background-color: #e6f2f0");
        mainView.setContent(mainPane); 
        mainView.setPrefHeight(650);
        mainView.setPrefWidth(1200);
        
        //service category post request sender
        addCategoryBtn.setOnAction(event -> {
            String name = nameField.getText();
            String description = descriptionField.getText();
            ServiceCategory serviceCategory = new ServiceCategory(name , description);
             try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/addServiceCategory");
                serv.addServiceCategory(serviceCategory);
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
    
    
    //data getter from server
    public List<ServiceCategory> getData(boolean search){
         
         
         List<ServiceCategory> serviceCats = null;
        if(!search){
                try {
                    DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getServiceCategories");
                    System.out.println("reasult set abt to be here");
                    serviceCats =   serv.getServiceCategories(); 
                    System.out.println("reasult set here");
                } catch (NotBoundException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else{
                    serviceHolder.getChildren().clear();

                try {
                    DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/searchCategories");
                    System.out.println("reasult set abt to be here");
                    serviceCats =   serv.searchServiceCategoriies(searchField.getText());
                    System.out.println("reasult set here");
                } catch (NotBoundException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return serviceCats;
        
    }
    
    //refresh the whole service category page
    public void refresh(){
        serviceCategories = null;
        boolean searched = false;
        if(searchField.getText() != null){
            searched = true;
        }
        serviceCategories = getData(searched);
        if(serviceCategories != null)
        for (ServiceCategory serviceCategorie : serviceCategories) {
            SingleServiceView singleService =  new SingleServiceView();
            serviceHolder.getChildren().add(singleService.service(serviceCategorie , mainPane));
        }
    }
}
