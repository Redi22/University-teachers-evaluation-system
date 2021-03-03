/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
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
public class MappedServiceView {
    
    public ScrollPane mappedServices(){
    Pane pane = new Pane();
       StackPane mainPane = new StackPane(); 
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setPrefWidth(1200);
        VBox contentHolder =  new VBox();
        Pane content =  new Pane();
        Label label5 = new Label();
        label5.setLayoutX(37.0);
        label5.setLayoutY(14.0);
        label5.setPrefHeight(34.0);
        label5.setPrefWidth(241.0);
        label5.setStyle("-fx-background-color: white;");
        label5.setText("Assign Service to Teacher");
        label5.setFont(new Font(16.0));

        TextField fullNameField =  new TextField();
        fullNameField.setLayoutX(37.0);
        fullNameField.setLayoutY(150.0);
        fullNameField.setPrefHeight(40.0);
        fullNameField.setPrefWidth(300.0);
        fullNameField.setPromptText("Full Name");

        TextArea descriptionField = new TextArea();
        descriptionField.setLayoutX(37.0);
        descriptionField.setLayoutY(200.0);
        descriptionField.setPrefHeight(120.0);
        descriptionField.setPrefWidth(300.0);
        descriptionField.setPromptText("Description");
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

        ComboBox phoneField =  new ComboBox();
        phoneField.getItems().addAll("Masters" , "PHD");
        phoneField.setLayoutX(37.0);
        phoneField.setLayoutY(55.0);
        phoneField.setPrefHeight(40.0);
        phoneField.setPrefWidth(300.0);
        phoneField.setPromptText("Phone");

       
 
        ComboBox emailField =  new ComboBox();
        emailField.getItems().addAll("Masters" , "PHD");
        emailField.setLayoutX(37.0);
        emailField.setLayoutY(100.0);
        emailField.setPrefHeight(40.0);
        emailField.setPrefWidth(300.0);
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
       contentHolder.setAlignment(Pos.CENTER); 
       DialogTitleBar.getChildren().addAll(label5, button4);
        contentHolder.getChildren().addAll(DialogTitleBar  , phoneField  , emailField   ,fullNameField,descriptionField, addTeacherBtn);
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
        
        SingleMappedServiceView singleView = new SingleMappedServiceView();
        
        HBox labelHolder = new HBox();
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
        VBox mapsContainer = new VBox();
        mapsContainer.getChildren().add(labelHolder);
        mapsContainer.setStyle("-fx-background-color: white");
        mapsContainer.setLayoutX(20);
        mapsContainer.setLayoutY(100);
        mapsContainer.setPadding(new Insets(20));
        for(int i=0; i<9; i++){
            HBox some = singleView.mappedServiceView();
            some.setAlignment(Pos.CENTER);
            some.setLayoutX(200);
            some.setLayoutY(80);
            Separator border =  new Separator();
            border.setOrientation(Orientation.HORIZONTAL);
            mapsContainer.getChildren().addAll(some , border);
        }
        
        HBox hBox0 = new HBox();
        hBox0.setLayoutX(20.0);
        hBox0.setLayoutY(20.0);
        hBox0.setSpacing(400.0);
        hBox0.setAlignment(Pos.CENTER);
        Label label6 = new Label();
        label6.setPrefHeight(40.0);
//        label5.setPrefWidth(241.0);
        label6.setStyle("-fx-font-size: 30;");
        label6.setText("Service - Level of Education");
        label6.setFont(new Font(16.0));

        Button button3 = new Button();
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(25.0);
        button3.setPrefWidth(120.0);
        button3.setStyle("-fx-background-color: teal;");
        button3.setText("Map Service");
        button3.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
        
        
        
        
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

        hBox0.getChildren().addAll(label6 , button3);
        pane.getChildren().addAll(hBox0 , mapsContainer); 
        mainPane.getChildren().add(pane);
        ScrollPane mainView = new ScrollPane();
        mainView.setStyle("-fx-background-color: #e6f2f0");
        mainView.setContent(mainPane); 
        mainView.setPrefHeight(650);
        mainView.setPrefWidth(1200);
        return mainView;
    }
}
