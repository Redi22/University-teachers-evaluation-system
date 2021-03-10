/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author kk
 */


//AppBar component class to use in views
public class AppBar {
    public HBox appBar(){
        HBox appBar = new HBox();
        Button logoutBtn =  new Button();
        FontAwesomeIcon logoutIcon = new FontAwesomeIcon();
        logoutBtn.setStyle("-fx-background-color: teal; -fx-color: white;");
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
        Label organization = new Label("Organization Name");
        organization.setAlignment(Pos.CENTER);
        organization.setTextFill(Color.WHITE);
        organization.setFont(new Font("System Bold", 20.0));
        organization.setPadding(new Insets(5));
        Label currentFullName =  new Label();
        Label currentEmail =  new Label();
        currentFullName.setGraphic(userAvatar);
        currentFullName.setAlignment(Pos.CENTER);
        currentFullName.setPrefHeight(30.0);
        currentFullName.setText(UniversityTeachersEvaluation.currentUser.getUser().getFullName());
        currentFullName.setTextFill(Color.WHITE);
        currentFullName.setFont(new Font("System Bold", 17.0));
        currentEmail.setAlignment(Pos.CENTER);
        currentEmail.setPrefHeight(12.0);
        currentEmail.setText(UniversityTeachersEvaluation.currentUser.getUser().getEmail());
        currentEmail.setTextFill(Color.WHEAT);
        appBarInfo.getChildren().addAll(currentFullName , currentEmail);
        appBar.getChildren().addAll(organization ,appBarInfo , logoutBtn);
   
        //event handler for logout 
        logoutBtn.setOnAction(event -> {
        LoginView loginView = new LoginView();
        Pane somePane = loginView.LoginView();
        ScrollPane scrollView = new ScrollPane();
        somePane.setLayoutX(500);
        somePane.setLayoutY(100);
         
        Pane pane = new Pane(); 
        SceneChanger sc =  new SceneChanger();

        pane.getChildren().add(somePane);
        Scene s = new Scene(pane, 1350 , 700);
        sc.changeScene(s);
            });
            return appBar;
        }
}
