/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author kk
 */
public class TeachersView  {
    public Pane teacherView(){
        
    
     Pane pane =  new Pane();
    
    
            pane.setStyle("-fx-background-color: #e6f2f0");
            
            AnchorPane content =  new AnchorPane();
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
        
     
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#b2d8d8"));
        content.setEffect(dropShadow);
        content.setLayoutX(900.0);
        content.setLayoutY(100.0);
        content.setPrefHeight(350.0);
        content.setPrefWidth(250.0);

       
        content.getChildren().addAll(label3, fullNameField , addTeacherBtn , phoneField  , emailField  , levelOfEd);
//        content.getChildren().add(newUsername);
//        content.getChildren().add(makeAdmin);
//        content.getChildren().add(Pass);
//        content.getChildren().add(label4);
//        content.getChildren().add(newPass);
//        content.getChildren().add(confNewPass);
        content.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        pane.getChildren().add(content);
//        pane.setRight(new HBox());

            
        
        
       TableView teachersTable = new TableView();
       TableColumn fullNameColumn =  new TableColumn();
       TableColumn idColumn = new TableColumn();
       TableColumn emailColumn =  new TableColumn();
       TableColumn phoneColumn = new TableColumn();
       TableColumn levelOfEdColumn = new TableColumn();
       TableColumn reviewColumn = new TableColumn();
        teachersTable.setLayoutX(20.0);
        teachersTable.setLayoutY(20.0);
        teachersTable.setPrefHeight(200.0);
        teachersTable.setPrefWidth(850.0);
        teachersTable.setStyle("-fx-border-radius: 20px");
         idColumn.setPrefWidth(50.0);
        idColumn.setText("ID ");

        fullNameColumn.setPrefWidth(150.0);
        fullNameColumn.setText("Full Name");

        emailColumn.setPrefWidth(130.0);
        emailColumn.setText("Email");

        phoneColumn.setMinWidth(0.0);
        phoneColumn.setPrefWidth(120.0);
        phoneColumn.setText("Phone");

        levelOfEdColumn.setMinWidth(0.0);
        levelOfEdColumn.setPrefWidth(160.0);
        levelOfEdColumn.setText("Level Of Education");

        reviewColumn.setMinWidth(0.0);
        reviewColumn.setPrefWidth(110.0);
        reviewColumn.setText("Last Review"); 
        teachersTable.getColumns().add(idColumn);
        teachersTable.getColumns().add(fullNameColumn);
        teachersTable.getColumns().add(emailColumn);
        teachersTable.getColumns().add(phoneColumn);
        teachersTable.getColumns().add(levelOfEdColumn);
        teachersTable.getColumns().add(reviewColumn);
    // 
        pane.getChildren().add(teachersTable);
        return pane;
    }
}
