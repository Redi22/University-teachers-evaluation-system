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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author kk
 */
public class SingleTeacherTaskView {
    public HBox taskView(){
         HBox pane =  new HBox();
       pane.setSpacing(30);
       Label label1 =  new Label("Service title");       
       Label label2 =  new Label("Level of Education");
       Label label3 =  new Label("30%");
       Label label4 = new Label("description description description description description description description description description description description description description description description description description description description description ");
       label4.setWrapText(true); 
       label4.setPrefHeight(100); 
       label4.setPrefWidth(600);
       label2.setFont(new Font(16.0));
       label1.setFont(new Font(16.0));
       label3.setFont(new Font(16.0));
       label3.setStyle("-fx-background-radius: 18; -fx-background-color: #e6fcfb");
       label3.setPadding(new Insets(5 ,15 ,5 ,15));
        Button doneBtn =  new Button(); 
        doneBtn.setLayoutX(450.0);
        doneBtn.setLayoutY(10.0);
        doneBtn.setMnemonicParsing(false);
        doneBtn.setPrefHeight(30.0);
        doneBtn.setPrefWidth(80.0); 
        doneBtn.setText("Done");
        doneBtn.setStyle("-fx-background-color: teal");
        doneBtn.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        FontAwesomeIcon fontAwesomeIcon6 = new FontAwesomeIcon();
        fontAwesomeIcon6.setLayoutX(762.0);
        fontAwesomeIcon6.setLayoutY(38.0);
        fontAwesomeIcon6.setSize("1.5em");
        fontAwesomeIcon6.setIconName("CHECK");
        fontAwesomeIcon6.setFill(Color.WHITE);
        
        
       
        doneBtn.setGraphic(fontAwesomeIcon6);
         
       pane.getChildren().addAll(label1, label2 ,label4, label3 , doneBtn );
       return pane;
    }
}
