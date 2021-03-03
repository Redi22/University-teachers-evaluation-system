/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.Service;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
public class ServicesView {
    
    public ScrollPane servicesView(){
        ScrollPane mainView = new ScrollPane();
    StackPane mainPane =  new StackPane();
    mainPane.setAlignment(Pos.CENTER);
    mainPane.setPrefWidth(1200);
    
     Pane pane =  new Pane();

        
            VBox contentHolder =  new VBox();
            
          Pane content =  new Pane();
          
            Label label3 = new Label();
            label3.setLayoutX(37.0);
        label3.setLayoutY(14.0);
        label3.setPrefHeight(34.0);
        label3.setPrefWidth(241.0);
        label3.setStyle("-fx-background-color: white;");
        label3.setText("Teacher Registration Form");
        label3.setFont(new Font(16.0));

        TextField fullNameField =  new TextField();
        fullNameField.setLayoutX(37.0);
        fullNameField.setLayoutY(55.0);
        fullNameField.setPrefHeight(34.0);
        fullNameField.setPrefWidth(200.0);
        fullNameField.setPromptText("Full Name");

        ComboBox levelOfEd = new ComboBox();
        levelOfEd.getItems().addAll("Masters" , "PHD");
        levelOfEd.setLayoutX(37.0);
        levelOfEd.setLayoutY(200.0);
        levelOfEd.setPrefHeight(34.0);
        levelOfEd.setPrefWidth(200.0);
        levelOfEd.setPromptText("Level of Education");
        Button addTeacherBtn = new Button();
        addTeacherBtn.setLayoutX(65.0);
        addTeacherBtn.setLayoutY(280.0);
        addTeacherBtn.setMnemonicParsing(false);
//        makeAdmin.setOnAction(this::makeAdmin);
        addTeacherBtn.setPrefHeight(35.0);
        addTeacherBtn.setPrefWidth(150.0);
        addTeacherBtn.setStyle("-fx-background-color: teal;");
        addTeacherBtn.setText("Register");
        addTeacherBtn.setTextFill(Color.valueOf("#fff8f8"));

        TextField phoneField =  new TextField();
        phoneField.setLayoutX(37.0);
        phoneField.setLayoutY(150.0);
        phoneField.setPrefHeight(34.0);
        phoneField.setPrefWidth(200.0);
        phoneField.setPromptText("Phone");

       
 
        TextField emailField =  new TextField();
        emailField.setLayoutX(37.0);
        emailField.setLayoutY(100.0);
        emailField.setPrefHeight(34.0);
        emailField.setPrefWidth(200.0);
        emailField.setPromptText("Email");
        
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
       DialogTitleBar.getChildren().addAll(label3, button4);
        contentHolder.getChildren().addAll(DialogTitleBar, fullNameField  , phoneField  , emailField  , levelOfEd , addTeacherBtn);
        contentHolder.setSpacing(20); 
        contentHolder.setPadding(new Insets(20 , 20 ,0 , 20));
        contentHolder.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        
        AnchorPane overlayContainer =  new AnchorPane();
        overlayContainer.setStyle("-fx-background-color: teal;");
        overlayContainer.setOpacity(0.2);
        overlayContainer.setPrefHeight(700);
        overlayContainer.setPrefWidth(1350);
        content.getChildren().addAll(overlayContainer ,contentHolder);
//        content.setStyle("-fx-background-color: #e6f2f0;");
//        content.setOpacity(0.3);
        HBox hBox0 = new HBox();
//        hBox0.setLayoutX(200.0);
//        hBox0.setLayoutY(80.0);
        hBox0.setSpacing(700.0);
        hBox0.setAlignment(Pos.CENTER);
        Label label5 = new Label();
        label5.setPrefHeight(40.0);
//        label5.setPrefWidth(241.0);
        label5.setStyle("-fx-font-size: 30;");
        label5.setText("Services View");
        label5.setFont(new Font(16.0));

        Button button3 = new Button();
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(25.0);
        button3.setPrefWidth(120.0);
        button3.setStyle("-fx-background-color: teal;");
        button3.setText("Add Service");
        button3.setTextFill(Color.valueOf("#fff8f8"));
        
        
        
        
        button3.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().add(content);
                    }
                });
        
        FontAwesomeIcon fontAwesomeIcon8 = new FontAwesomeIcon();
        fontAwesomeIcon8.setIconName("PLUS");
        fontAwesomeIcon8.setSize("1.6em"); 
        fontAwesomeIcon8.setFill(Color.WHITE);
        button3.setGraphic(fontAwesomeIcon8);

        hBox0.getChildren().addAll(label5 , button3);
        
        VBox serviceHolder =  new VBox();
//       
        serviceHolder.setLayoutX(50);
        serviceHolder.setLayoutY(70);
        serviceHolder.setSpacing(20);
        
        
        for(int i=0; i < 4 ; i++){
            
            HBox serviceHolderH = new HBox();
            serviceHolderH.setSpacing(30);
            for(int j=0; j < 2 ; j++){
                Service service =  new Service(1, "name here" , 32.0 , "lorem ipsum something something goes here as a description" ,2 );
                SingleServiceView singleService =  new SingleServiceView();
                 serviceHolderH.getChildren().add(singleService.service(service));
            }
            serviceHolder.getChildren().add(serviceHolderH);
        
        }
        pane.getChildren().add(hBox0);
        
        pane.getChildren().add(serviceHolder);
        pane.setStyle("-fx-background-color: #e6f2f0");
        mainPane.getChildren().add(pane);
        mainView.setStyle("-fx-background-color: #e6f2f0");
        mainView.setContent(mainPane); 
        mainView.setPrefHeight(650);
        mainView.setPrefWidth(1200);
            return mainView;
    }
    
}
