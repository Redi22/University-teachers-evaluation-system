/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author kk
 */
public class NavDrawer {
      private  Button navBtn1;
      private  Button navBtn2;
      private  Button navBtn3;
      private  Button navBtn4;
      private  Button navBtn5;

    public VBox navDrawer(){
        
    
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
     navBtn1 = new Button();
     navBtn2 = new Button();
    navBtn3 = new Button();
     navBtn4 = new Button();
     navBtn5 = new Button();
    navBtn1.setTextFill(Color.WHITE);
    navDrawer.setPrefHeight(700.0);
        navDrawer.setPrefWidth(158.0);
        navDrawer.setSpacing(5.0);
        

        navBtn2.setMnemonicParsing(false);
        navBtn2.setPrefWidth(150.0);
        navBtn2.setPrefHeight(33.0);
        navBtn2.setStyle("-fx-background-color: teal;");
        navBtn2.setText("Services");
        navBtn2.setTextFill(Color.valueOf("#fff8f8"));
        navBtn2.setGraphic(fontAwesomeIcon2);
        
        navBtn3.setMnemonicParsing(false);
        navBtn3.setPrefWidth(150.0);        
        navBtn3.setPrefHeight(33.0);
        navBtn3.setStyle("-fx-background-color: teal;");
        navBtn3.setText("Evaluation");
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
        navBtn1.setText("Teachers");
        navBtn1.setTextFill(Color.valueOf("#fff8f8"));
        navBtn1.setGraphic(fontAwesomeIcon1);
       
     
         navBtn1.setOnAction(
                new  EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            SceneChanger sc =  new SceneChanger();
                           
                            NavDrawer navDrawerClass = new NavDrawer();
                            AppBar appBarClass = new AppBar();
                            HBox appBar = appBarClass.appBar();
                            VBox navDrawer = navDrawerClass.navDrawer();
                            TeachersView tv = new TeachersView();
                            Pane somePane = tv.teacherView();
                            somePane.setLayoutX(160);
                            somePane.setLayoutY(53);
                            somePane.setPrefHeight(650);
                            somePane.setPrefWidth(1350); 
                            navDrawerClass.colorChanger();
                            navDrawerClass.navBtn1.setStyle("-fx-background-color: #006666");
                            Pane pane = new Pane();
                            pane.getChildren().addAll(appBar , navDrawer ,somePane );
                            Scene s = new Scene(pane, 1350 , 700);
                            sc.changeScene(s);
                        }
                });
         navBtn2.setOnAction(
                new  EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                              SceneChanger sc =  new SceneChanger();
                           
                            NavDrawer navDrawerClass = new NavDrawer();
                            AppBar appBarClass = new AppBar();
                            HBox appBar = appBarClass.appBar();
                            VBox navDrawer = navDrawerClass.navDrawer();
                            ServicesView tv = new ServicesView();
                            ScrollPane somePane = tv.servicesView();
                            somePane.setLayoutX(160);
                            somePane.setLayoutY(53);
                            somePane.setPrefHeight(650);
                            somePane.setPrefWidth(1350); 
                            navDrawerClass.colorChanger();
                            navDrawerClass.navBtn2.setStyle("-fx-background-color: #006666");
                            Pane pane = new Pane();
                            pane.getChildren().addAll(appBar , navDrawer ,somePane );
                            Scene s = new Scene(pane, 1350 , 700);
                            sc.changeScene(s);
                        }
                });
         
            navBtn3.setOnAction(
                new  EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                              SceneChanger sc =  new SceneChanger();
                           
                            NavDrawer navDrawerClass = new NavDrawer();
                            AppBar appBarClass = new AppBar();
                            HBox appBar = appBarClass.appBar();
                            VBox navDrawer = navDrawerClass.navDrawer();
                            TeacherEvaluationView tv = new TeacherEvaluationView();
                            StackPane somePane = tv.teacherEvaluationView();
                            somePane.setLayoutX(160);
                            somePane.setLayoutY(53);
                            somePane.setPrefHeight(650);
                            somePane.setPrefWidth(1350); 
                            navDrawerClass.colorChanger();
                            navDrawerClass.navBtn3.setStyle("-fx-background-color: #006666");
                            Pane pane = new Pane();
                            pane.getChildren().addAll(appBar , navDrawer ,somePane );
                            Scene s = new Scene(pane, 1350 , 700);
                            sc.changeScene(s);
                        }
                });
    navDrawer.getChildren().addAll(navBtn1, navBtn2, navBtn3, navBtn4 , navBtn5);
    return navDrawer;
    }
    
    public void colorChanger(){
        navBtn1.setStyle("-fx-background-color: teal");
        navBtn2.setStyle("-fx-background-color: teal");
        navBtn3.setStyle("-fx-background-color: teal");
        navBtn4.setStyle("-fx-background-color: teal");
        navBtn5.setStyle("-fx-background-color: teal");
    }
    
  
}
