/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 *
 * @author kk
 */
public class UniversityTeachersEvaluation extends Application{
    static Stage stage;
 @Override // Override the start method in the Application class
 public void start(Stage stage) {
     this.stage = stage;
     
        Pane pane =  new Pane();

    AppBar appBarClass =  new AppBar();
    HBox appBar = appBarClass.appBar();
        pane.setStyle("-fx-background-color: #e6f2f0");
        pane.getChildren().add(appBar);
        NavDrawer navBarClass = new NavDrawer();
        VBox navDrawer = navBarClass.navDrawer();
        pane.getChildren().add(navDrawer); 
        
        
     
    ServicesView teachers = new ServicesView();
    ScrollPane somePane = teachers.servicesView();
//    somePane.setStyle("-fx-background-color: #e6f2f0");
//    somePane.setPrefWidth(1300);
    ScrollPane scrollView = new ScrollPane();
    somePane.setLayoutX(158);
    somePane.setLayoutY(51);
//    somePane.setContent(somePane);
    pane.getChildren().add(somePane);
    Scene  scene =  new Scene(pane, 1350 , 700);
    stage.setScene(scene); // Place the scene in the stage
    stage.show(); // Display the stage
 }
 
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
