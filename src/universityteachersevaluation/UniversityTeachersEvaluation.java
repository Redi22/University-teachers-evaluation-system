/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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
    private TextArea ta;
//    private boolean isServer = true;
    
//    private NetworkConnection netConnection  = isServer ? createServer() : createClient();
    
//    @Override 
//    public void init() throws Exception{
//        netConnection.startConnection();
//    }
//    
//    @Override
//    public void stop() throws Exception{
//        netConnection.closeConnection();
//    }
//    
    
 @Override // Override the start method in the Application class
 public void start(Stage stage) {
     
     this.stage = stage;
     boolean admin = true;
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
        
//       
    pane.getChildren().add(somePane);
    Scene  scene =  new Scene(pane, 1350 , 700);
    stage.setScene(scene); // Place the scene in the stage
    stage.show(); // Display the stage
 }
// 
// 
// @Override 
// public void stop(){
//     socket.close();
//
// }
// 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String host = "127.0.0.1";
//        try
//{
////Convert the URL string into an INetAddress
////object…
//InetAddress theAddress =
//InetAddress.getByName(host);
//Socket socket;
//
//
//try
//{
////Attempt to establish a socket on
////port i…
//    int i = 1;
//socket = new Socket(host, i);
//
//ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//Serializable data = "some";
//out.writeObject(data);
////If no IOException thrown, there must
////be a service running on the port…
//socket.setTcpNoDelay(true);
//System.out.println("connection made in port " + i + " host " + host );
//}
//catch (IOException ioEx)
//{
//    System.out.println("io exception");
//}// No server on this port
//
//}
//catch (UnknownHostException uhEx)
//{
//    System.out.println("unknown host exception");
//
//}
        launch(args);
    }
    
    
     
    
}
