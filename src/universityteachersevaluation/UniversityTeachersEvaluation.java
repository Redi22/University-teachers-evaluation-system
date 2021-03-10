/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.CurrentUser;
import Models.Teacher;
import Models.User;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
    
    static CurrentUser currentUser = new CurrentUser();

    
 @Override // Override the start method in the Application class
 public void start(Stage stage) {
     
     this.stage = stage;
     boolean admin = true;
     Pane pane =  new Pane();
        
     pane.setStyle("-fx-background-color: #e6f2f0");
  
     
    LoginView loginView = new LoginView();
    Pane somePane = loginView.LoginView();

    ScrollPane scrollView = new ScrollPane();
    somePane.setLayoutX(500);
    somePane.setLayoutY(100);
        
//       
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
