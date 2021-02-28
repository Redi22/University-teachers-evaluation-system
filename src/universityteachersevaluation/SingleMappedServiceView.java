/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author kk
 */
public class SingleMappedServiceView {
    public HBox mappedServiceView(){
       HBox pane =  new HBox();
       pane.setSpacing(30);
       pane.setPrefHeight(100);
       Label label1 =  new Label("Service title");       
       Label label2 =  new Label("Level of Education");
       Label label3 =  new Label("30%");
       Label label4 = new Label("description description description description description description description description description description description description description description description description description description description description ");
       label4.setWrapText(true); 
       label4.setPrefHeight(100); 
       label4.setPrefWidth(400); 
       label2.setFont(new Font(16.0));
       label1.setFont(new Font(16.0));
       label3.setFont(new Font(16.0));
       label3.setStyle("-fx-background-radius: 18; -fx-background-color: #e6fcfb");
       label3.setPadding(new Insets(5 ,15 ,5 ,15));
        Button makeAdmin =  new Button(); 
        makeAdmin.setLayoutX(450.0);
        makeAdmin.setLayoutY(10.0);
        makeAdmin.setMnemonicParsing(false);
        makeAdmin.setPrefHeight(35.0);
        makeAdmin.setPrefWidth(39.0);
        makeAdmin.setStyle("-fx-background-color: #e6fcfb");
        makeAdmin.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        FontAwesomeIcon fontAwesomeIcon6 = new FontAwesomeIcon();
        fontAwesomeIcon6.setLayoutX(762.0);
        fontAwesomeIcon6.setLayoutY(38.0);
        fontAwesomeIcon6.setSize("2em");
        fontAwesomeIcon6.setIconName("TRASH");
        fontAwesomeIcon6.setFill(Color.TEAL);
        
        
        Button makeAdmin1 = new Button();
        makeAdmin1.setLayoutX(400.0);
        makeAdmin1.setLayoutY(9.0);
        makeAdmin1.setMnemonicParsing(false);
        makeAdmin1.setPrefHeight(35.0);
        makeAdmin1.setPrefWidth(39.0);
        makeAdmin1.setStyle("-fx-background-color: #e6fcfb;");
        makeAdmin1.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        FontAwesomeIcon fontAwesomeIcon7 = new FontAwesomeIcon();
        fontAwesomeIcon7.setFill(Color.TEAL);
        fontAwesomeIcon7.setLayoutX(705.0);
        fontAwesomeIcon7.setSize("2em");
        fontAwesomeIcon7.setIconName("EDIT");
        fontAwesomeIcon7.setLayoutY(38.0);
        makeAdmin.setGraphic(fontAwesomeIcon6);
        makeAdmin1.setGraphic(fontAwesomeIcon7);
        
       pane.getChildren().addAll(label1, label2 ,label4, label3 , makeAdmin , makeAdmin1);
       return pane;
    }
}
