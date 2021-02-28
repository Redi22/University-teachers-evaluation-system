/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author kk
 */
public class AppBar {
    public HBox appBar(){
         HBox appBar = new HBox();
    Button logoutBtn =  new Button();
    logoutBtn.setStyle("-fx-background-color: teal; -fx-color: white;");
    FontAwesomeIcon logoutIcon = new FontAwesomeIcon();
    logoutIcon.setIconName("ANGLE_DOUBLE_RIGHT");
    logoutIcon.setSize("3em"); 
    logoutIcon.setFill(Color.WHITE);
    logoutBtn.setGraphic(logoutIcon);
    appBar.setPrefWidth(1400);
    FontAwesomeIcon userAvatar = new FontAwesomeIcon();
    userAvatar.setIconName("USER");
    userAvatar.setFill(Color.WHITE);
    appBar.setStyle("-fx-background-color: teal");
    VBox appBarInfo = new VBox();
    appBarInfo.setPadding(new Insets(0, 0, 5, 850));
    Label organization = new Label("organization Name");
    organization.setAlignment(Pos.CENTER);
    organization.setTextFill(Color.WHITE);
    organization.setFont(new Font("System Bold", 20.0));
    organization.setPadding(new Insets(5));
    Label currentFullName =  new Label();
    Label currentEmail =  new Label();
    currentFullName.setGraphic(userAvatar);
     currentFullName.setAlignment(Pos.CENTER);
        currentFullName.setPrefHeight(30.0);
//        currentFullName.setPrefWidth(200.0);
        currentFullName.setText("Full Name");
        currentFullName.setTextFill(Color.WHITE);
        currentFullName.setFont(new Font("System Bold", 17.0));
        currentEmail.setAlignment(Pos.CENTER);
        currentEmail.setPrefHeight(12.0);
//        currentEmail.setPrefWidth(100.0);
        currentEmail.setText("example@gmail.com");
        currentEmail.setTextFill(Color.WHEAT);
        appBarInfo.getChildren().addAll(currentFullName , currentEmail);
        appBar.getChildren().addAll(organization ,appBarInfo , logoutBtn);
   
        return appBar;
    }
}
