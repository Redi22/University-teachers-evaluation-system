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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author kk
 */
public class MainLayout {
    public Pane mainPane(){
    
         Pane pane =  new Pane();

    
    FontAwesomeIcon fontAwesomeIcon1 = new FontAwesomeIcon();
    fontAwesomeIcon1.setIconName("USERS");
    fontAwesomeIcon1.setFill(Color.WHITE);
    FontAwesomeIcon fontAwesomeIcon2 = new FontAwesomeIcon();
    fontAwesomeIcon2.setIconName("USERS");
    fontAwesomeIcon2.setFill(Color.WHITE);
    FontAwesomeIcon fontAwesomeIcon3 = new FontAwesomeIcon();
    fontAwesomeIcon3.setIconName("USERS");
    fontAwesomeIcon3.setFill(Color.WHITE);
    FontAwesomeIcon fontAwesomeIcon4 = new FontAwesomeIcon();
    fontAwesomeIcon4.setIconName("USERS");
    fontAwesomeIcon4.setFill(Color.WHITE);
    FontAwesomeIcon fontAwesomeIcon5 = new FontAwesomeIcon();
    fontAwesomeIcon5.setIconName("USERS");
    fontAwesomeIcon5.setFill(Color.WHITE);
    
    VBox navDrawer = new VBox();
    navDrawer.setStyle("-fx-background-color: #008381; ");
    navDrawer.setPadding(new Insets(15, 15, 15, 15));
    navDrawer.setLayoutY(50.0);
    Button navBtn1 = new Button();
    Button navBtn2 = new Button();
    Button navBtn3 = new Button();
    Button navBtn4 = new Button();
    Button navBtn5 = new Button();
    navBtn1.setTextFill(Color.WHITE);
    navDrawer.setPrefHeight(700.0);
        navDrawer.setPrefWidth(158.0);
        navDrawer.setSpacing(5.0);
        

        navBtn2.setMnemonicParsing(false);
        navBtn2.setPrefWidth(150.0);
        navBtn2.setPrefHeight(33.0);
        navBtn2.setStyle("-fx-background-color: #006666;");
        navBtn2.setText("Student");
        navBtn2.setTextFill(Color.valueOf("#fff8f8"));
        navBtn2.setGraphic(fontAwesomeIcon2);
        
        navBtn3.setMnemonicParsing(false);
        navBtn3.setPrefWidth(150.0);        
        navBtn3.setPrefHeight(33.0);
        navBtn3.setStyle("-fx-background-color: teal;");
        navBtn3.setText("Student");
        navBtn3.setTextFill(Color.valueOf("#fff8f8"));
        navBtn3.setGraphic(fontAwesomeIcon3);
        
        navBtn4.setMnemonicParsing(false);
        navBtn4.setPrefWidth(150.0);        
        navBtn4.setPrefHeight(33.0);
        navBtn4.setStyle("-fx-background-color: teal;");
        navBtn4.setText("Student");
        navBtn4.setTextFill(Color.valueOf("#fff8f8"));
        navBtn4.setGraphic(fontAwesomeIcon4);
        
        navBtn5.setMnemonicParsing(false);
        navBtn5.setPrefWidth(150.0);
        navBtn5.setPrefHeight(33.0);
        navBtn5.setStyle("-fx-background-color: teal;");
        navBtn5.setText("Student");
        navBtn5.setTextFill(Color.valueOf("#fff8f8"));
        navBtn5.setGraphic(fontAwesomeIcon5);
        
        navBtn1.setMnemonicParsing(false);
        navBtn1.setPrefWidth(150.0);
        navBtn1.setPrefHeight(33.0);
        navBtn1.setStyle("-fx-background-color: teal;");
        navBtn1.setText("Service Detail");
        navBtn1.setTextFill(Color.valueOf("#fff8f8"));
        navBtn1.setGraphic(fontAwesomeIcon1);
       
     
         navBtn1.setOnAction(
                new  EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            SceneChanger sc =  new SceneChanger();
                            TeachersView tv = new TeachersView();
                            Scene s = new Scene(tv.teacherView());
                            sc.changeScene(s);
                        }
                });
    navDrawer.getChildren().addAll(navBtn1, navBtn2, navBtn3, navBtn4 , navBtn5);
        pane.setStyle("-fx-background-color: #e6f2f0");
//        pane.getChildren().add(appBar);
        pane.getChildren().add(navDrawer); 
        
        return pane;
}
    
}
