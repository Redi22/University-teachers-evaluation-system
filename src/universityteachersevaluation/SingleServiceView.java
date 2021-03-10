/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.Service;
import Models.ServiceCategory;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

/**
 *
 * @author kk
 */
public class SingleServiceView {
    
    private Button deleteBtn;
    
//    onEditFunction(){
//        
//    }
    
    public Pane service(ServiceCategory service , StackPane mainPane){
        Pane anchorPane = new Pane();
         anchorPane.setLayoutX(168.0);
        anchorPane.setLayoutY(90.0);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(1000.0);
        anchorPane.setStyle("-fx-background-color: white; -fx-background-radius: 12;");
        deleteBtn =  new Button();
        deleteBtn.setLayoutX(950.0);
        deleteBtn.setLayoutY(10.0);
        deleteBtn.setMnemonicParsing(false);
        deleteBtn.setPrefHeight(35.0);
        deleteBtn.setPrefWidth(39.0);
        deleteBtn.setStyle("-fx-background-color: #e6fcfb");
        deleteBtn.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        Label label3 = new Label(); 
        label3.setLayoutX(14.0);
        label3.setLayoutY(10.0);
        label3.setPrefHeight(24.0);
        label3.setPrefWidth(410.0);
        label3.setStyle("-fx-background-color: white; -fx-font-size: 25;");
        label3.setText(service.getName());
        label3.setFont(new Font(16.0));

        FontAwesomeIcon fontAwesomeIcon6 = new FontAwesomeIcon();
        fontAwesomeIcon6.setLayoutX(762.0);
        fontAwesomeIcon6.setLayoutY(38.0);
        fontAwesomeIcon6.setSize("2em");
        fontAwesomeIcon6.setIconName("TRASH");
        fontAwesomeIcon6.setFill(Color.TEAL);
        Label label4 = new Label(); 
        label4.setLayoutX(14.0);
        label4.setLayoutY(50.0);
//        label4.setPrefHeight(200.0);
        label4.setPrefWidth(950.0);
        label4.setStyle("-fx-background-color: white;");
        label4.setText(service.getDescription());
        label4.setWrapText(true);
        label4.setFont(new Font(14.0));

        Button editBtn = new Button();
        editBtn.setLayoutX(900.0); 
        editBtn.setLayoutY(9.0);
        editBtn.setMnemonicParsing(false);
        editBtn.setPrefHeight(35.0);
        editBtn.setPrefWidth(39.0);
        editBtn.setStyle("-fx-background-color: #e6fcfb;");
        editBtn.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        Button makeAdmin3 = new Button();
        makeAdmin3.setText("Details");
        makeAdmin3.setLayoutX(900.0);
        makeAdmin3.setLayoutY(150.0);
        makeAdmin3.setMnemonicParsing(false);
        makeAdmin3.setPrefHeight(30.0);
        makeAdmin3.setPrefWidth(80.0);
        makeAdmin3.setTextFill(Color.BLACK);
        makeAdmin3.setStyle("-fx-background-color: teal;");
        makeAdmin3.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
        
        
         VBox contentHolder =  new VBox();
            
          Pane content =  new Pane();
          
            Label editLabel = new Label();
            editLabel.setLayoutX(37.0);
        editLabel.setLayoutY(14.0);
        editLabel.setPrefHeight(34.0);
        editLabel.setPrefWidth(241.0);
        editLabel.setStyle("-fx-background-color: white;");
        editLabel.setText("Service Category ");
        editLabel.setFont(new Font(16.0));

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
        descriptionField.setWrapText(true);
       
        FontAwesomeIcon cancelBtn = new FontAwesomeIcon();
        cancelBtn.setIconName("REMOVE"); 
        cancelBtn.setFill(Color.TEAL);
        
        Button button4 = new Button();
        button4.setMnemonicParsing(false);
        button4.setLayoutY(400);
        button4.setLayoutX(120);
        button4.setPrefHeight(50.0);
        button4.setPrefWidth(50.0); 
        button4.setStyle("-fx-background-color: white;");
        button4.setGraphic(cancelBtn);
        button4.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
        

        Button button5 = new Button();
        button5.setMnemonicParsing(false);
        button5.setLayoutY(400);
        button5.setLayoutX(120);
        button5.setPrefHeight(50.0);
        button5.setPrefWidth(50.0); 
        button5.setStyle("-fx-background-color: white;");
        button5.setGraphic(cancelBtn);
        button5.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
        
     
         Button button6 = new Button();
        
        button6.setPrefHeight(50.0);
        button6.setPrefWidth(50.0); 
        button6.setStyle("-fx-background-color: white;");
        
        button6.setGraphic(cancelBtn);
        button6.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#b2d8d8"));
        contentHolder.setEffect(dropShadow);
        contentHolder.setLayoutX(430.0);
        contentHolder.setLayoutY(130.0);
        contentHolder.setPrefHeight(400);
        contentHolder.setPrefWidth(300);
 
       HBox DialogTitleBar =  new HBox();
       DialogTitleBar.setAlignment(Pos.CENTER);
       DialogTitleBar.getChildren().addAll(editLabel, button4);
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
        
        
        editBtn.setOnAction(event -> {
            descriptionField.setText(service.getDescription());
            nameField.setText(service.getName()); 
           mainPane.getChildren().add(content);
        });
 makeAdmin3.setOnAction(
                new  EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            System.out.println("Services page");
                            SceneChanger sc =  new SceneChanger();
                            NavDrawer navDrawerClass = new NavDrawer();
                            AppBar appBarClass = new AppBar();
                            HBox appBar = appBarClass.appBar();
                            VBox navDrawer = navDrawerClass.navDrawer();
                            MappedServiceView tv = new MappedServiceView();
                            ScrollPane somePane = tv.mappedServices(service);
                            somePane.setLayoutX(160);
                            somePane.setLayoutY(53);
                            somePane.setPrefHeight(650);
                            somePane.setPrefWidth(1350); 
                            Pane pane = new Pane();
                            pane.getChildren().addAll(appBar , navDrawer ,somePane );
                            Scene s = new Scene(pane, 1350 , 700);
                            sc.changeScene(s);
                        }
                });
 
        Pane deleteDialog = new Pane();
        VBox dialContent = new VBox();
        HBox delDialogTitleBar =  new HBox();
        delDialogTitleBar.setAlignment(Pos.CENTER);
        Label delTitle = new Label(); 
        delDialogTitleBar.setSpacing(200);
        delDialogTitleBar.getChildren().addAll(delTitle, button5);
        Label prompt = new Label();
        prompt.setText("Are you sure?");
        prompt.setFont(new Font(20.0));
        Button confirmBtn = new Button("Confirm Delete");
        confirmBtn.setStyle("-fx-background-color: teal");
        
        
        dialContent.setEffect(dropShadow);
        dialContent.setLayoutX(400.0);
        dialContent.setLayoutY(200.0);
        dialContent.setPrefHeight(200);
        dialContent.setPrefWidth(300);
        dialContent.getChildren().addAll(delDialogTitleBar , prompt , confirmBtn);
        dialContent.setSpacing(20); 
        dialContent.setPadding(new Insets(20 , 20 ,30 , 20));
        dialContent.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        dialContent.setAlignment(Pos.CENTER);
        deleteDialog.getChildren().addAll(overlayContainer , dialContent);
        
         deleteBtn.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().add(deleteDialog);
                    }
                });
 
        FontAwesomeIcon fontAwesomeIcon7 = new FontAwesomeIcon();
        fontAwesomeIcon7.setFill(Color.TEAL);
        fontAwesomeIcon7.setLayoutX(705.0);
        fontAwesomeIcon7.setSize("2em");
        fontAwesomeIcon7.setIconName("EDIT");
        fontAwesomeIcon7.setLayoutY(38.0);
        deleteBtn.setGraphic(fontAwesomeIcon6);
        editBtn.setGraphic(fontAwesomeIcon7);
        
         DropShadow dropShadow1 =  new DropShadow();
         dropShadow1.setColor(Color.valueOf("#b2d8d8"));

         anchorPane.setEffect(dropShadow1);
        
        anchorPane.getChildren().add(label3);
        anchorPane.getChildren().add(label4);
        
        if(UniversityTeachersEvaluation.currentUser.getUser().isAdmin()){
            anchorPane.getChildren().addAll(editBtn , deleteBtn );
        }
        anchorPane.getChildren().addAll(makeAdmin3);
        
        addCategoryBtn.setOnAction(event -> {
            String name = nameField.getText();
            String desc = descriptionField.getText();
            ServiceCategory sc = new ServiceCategory(service.getId() , name , desc);
            
             try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5051/editServiceCategory");
                 System.out.println("service created");
                serv.editServiceCategory(sc); 
                System.out.println("service done");
                mainPane.getChildren().remove(content);

            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
         button4.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(content);
                          mainPane.getChildren().remove(content);
                         mainPane.getChildren().remove(deleteDialog);
                    }
                });
          button5.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(content);
                          mainPane.getChildren().remove(content);
                         mainPane.getChildren().remove(deleteDialog);
                    }
                });
         button6.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(content);
                          mainPane.getChildren().remove(content);
                         mainPane.getChildren().remove(deleteDialog);
                    }
                });
        confirmBtn.setOnAction(event -> {
            try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/deleteServiceCategory");
                serv.deleteServiceCategory(service.getId());
                mainPane.getChildren().remove(deleteDialog);

            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return anchorPane;

    }
}
