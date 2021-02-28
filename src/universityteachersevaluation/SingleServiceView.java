/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author kk
 */
public class SingleServiceView {
    public Pane service(){
        Pane anchorPane = new Pane();
         anchorPane.setLayoutX(168.0);
        anchorPane.setLayoutY(90.0);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(500.0);
        anchorPane.setStyle("-fx-background-color: white; -fx-background-radius: 12;");
        Button makeAdmin =  new Button();
        makeAdmin.setLayoutX(450.0);
        makeAdmin.setLayoutY(10.0);
        makeAdmin.setMnemonicParsing(false);
        makeAdmin.setPrefHeight(35.0);
        makeAdmin.setPrefWidth(39.0);
        makeAdmin.setStyle("-fx-background-color: #e6fcfb");
        makeAdmin.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        Label label3 = new Label(); 
        label3.setLayoutX(14.0);
        label3.setLayoutY(10.0);
        label3.setPrefHeight(24.0);
        label3.setPrefWidth(410.0);
        label3.setStyle("-fx-background-color: white; -fx-font-size: 25;");
        label3.setText("Service Name");
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
        label4.setPrefWidth(450.0);
        label4.setStyle("-fx-background-color: white;");
        label4.setText("description description description description description description description description description description description description description description description description description description description ");
        label4.setWrapText(true);
        label4.setFont(new Font(14.0));

        Button makeAdmin1 = new Button();
        makeAdmin1.setLayoutX(400.0);
        makeAdmin1.setLayoutY(9.0);
        makeAdmin1.setMnemonicParsing(false);
        makeAdmin1.setPrefHeight(35.0);
        makeAdmin1.setPrefWidth(39.0);
        makeAdmin1.setStyle("-fx-background-color: #e6fcfb;");
        makeAdmin1.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        Button makeAdmin3 = new Button();
        makeAdmin3.setText("Details");
        makeAdmin3.setLayoutX(400.0);
        makeAdmin3.setLayoutY(150.0);
        makeAdmin3.setMnemonicParsing(false);
        makeAdmin3.setPrefHeight(30.0);
        makeAdmin3.setPrefWidth(80.0);
        makeAdmin3.setTextFill(Color.BLACK);
        makeAdmin3.setStyle("-fx-background-color: teal;");
        makeAdmin3.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
 makeAdmin3.setOnAction(
                new  EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            SceneChanger sc =  new SceneChanger();
                           
                            NavDrawer navDrawerClass = new NavDrawer();
                            AppBar appBarClass = new AppBar();
                            HBox appBar = appBarClass.appBar();
                            VBox navDrawer = navDrawerClass.navDrawer();
                            MappedServiceView tv = new MappedServiceView();
                            ScrollPane somePane = tv.mappedServices();
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
        FontAwesomeIcon fontAwesomeIcon7 = new FontAwesomeIcon();
        fontAwesomeIcon7.setFill(Color.TEAL);
        fontAwesomeIcon7.setLayoutX(705.0);
        fontAwesomeIcon7.setSize("2em");
        fontAwesomeIcon7.setIconName("EDIT");
        fontAwesomeIcon7.setLayoutY(38.0);
        makeAdmin.setGraphic(fontAwesomeIcon6);
        makeAdmin1.setGraphic(fontAwesomeIcon7);
        
         DropShadow dropShadow =  new DropShadow();
         dropShadow.setColor(Color.valueOf("#b2d8d8"));

         anchorPane.setEffect(dropShadow);
        
        anchorPane.getChildren().add(makeAdmin);
        anchorPane.getChildren().add(label3);
        anchorPane.getChildren().add(label4);
        anchorPane.getChildren().addAll(makeAdmin1);
        anchorPane.getChildren().addAll(makeAdmin3);
        return anchorPane;

    }
}
